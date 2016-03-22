package br.com.cds.connecta.framework.core.search;

import br.com.cds.connecta.framework.core.context.ConnectaConfigurationService;
import br.com.cds.connecta.framework.core.search.solradapter.*;
import static br.com.cds.connecta.framework.core.search.solradapter.SolrWorkAdapterUtils.*;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.hibernate.search.backend.*;
import org.hibernate.search.backend.spi.BackendQueueProcessor;
import org.hibernate.search.spi.WorkerBuildContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.hibernate.search.indexes.spi.DirectoryBasedIndexManager;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Backend processor para indexar os dados no Solr ao invés do Lucene
 *
 * @author Vinicius Pires
 */
public class HibernateSearchSolrIndexer implements BackendQueueProcessor, ApplicationContextAware, Observer {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static final Logger logger = Logger.getLogger(HibernateSearchSolrIndexer.class.getName());

    private HttpSolrServer solrServer;
    private ApplicationContext applicationContext;

    @Override
    public void initialize(Properties properties, WorkerBuildContext workerBuildContext, DirectoryBasedIndexManager directoryBasedIndexManager) {
        ConnectaConfigurationService configService = applicationContext.getBean(ConnectaConfigurationService.class);
        configService.addObserver(this);
        
        setNewHttpSolrServer(configService.getConfiguration().getSolrBackend());
    }

    @Override
    public void close() {
        solrServer.shutdown();
        logger.info("Closing.");
    }

    @Override
    public void applyWork(List<LuceneWork> luceneWorks, IndexingMonitor indexingMonitor) {
        List<SolrInputDocument> solrInputDocuments = new ArrayList<>(luceneWorks.size());
        List<String> idsForDeletion = new ArrayList<>();
        Boolean purgeAll = false;

        for (LuceneWork work : luceneWorks) {
            logger.log(Level.INFO, "Running Lucene work: {0}", work);

            SolrWorkAdapter adapter = getSolrWorkAdapter(work);
            SolrInputDocument document = adapter.adaptRequest(work, idsForDeletion, purgeAll);
            if (document != null) {
                solrInputDocuments.add(document);
            }
        }

        commitAndFinish(idsForDeletion, purgeAll, solrInputDocuments);
    }

    /**
     *
     * @param work work
     * @param indexingMonitor indexingMonitor
     */
    @Override
    public void applyStreamWork(LuceneWork work, IndexingMonitor indexingMonitor) {
        List<SolrInputDocument> solrInputDocuments = new ArrayList<>(1);
        List<String> idsForDeletion = new ArrayList<>();
        Boolean purgeAll = false;

        SolrWorkAdapter adapter = getSolrWorkAdapter(work);
        SolrInputDocument solrInputDocument = adapter.adaptRequest(work, idsForDeletion, purgeAll);
        solrInputDocuments.add(solrInputDocument);

        commitAndFinish(idsForDeletion, purgeAll, solrInputDocuments);
    }

    @Override
    public Lock getExclusiveWriteLock() {
        return writeLock;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void update(Observable o, Object arg) {
        setNewHttpSolrServer(((ConnectaConfigurationService)o).getConfiguration().getSolrBackend());
    }

    @Override
    public void indexMappingChanged() {
        logger.info("[UnsupportedOperation] Index mapping changed");
    }
    
    public void setNewHttpSolrServer(String location) {
        solrServer = new HttpSolrServer(location);
    }

    private void commitAndFinish(List<String> idsForDeletion, Boolean purgeAll, List<SolrInputDocument> solrInputDocuments) throws RuntimeException {
        try {
            deleteDocs(idsForDeletion, purgeAll);

            if (solrInputDocuments.size() > 0) {
                solrServer.add(solrInputDocuments);
                commit(solrInputDocuments);
            } else {
                commit();
            }
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException("Failed to update solr", e);
        }
    }

    private void deleteDocs(Collection<String> collection, boolean purgeAll) throws IOException, SolrServerException {
        if (purgeAll) {
            logger.info("RUNNING PURGE ALL SOLR WORK");
            solrServer.deleteByQuery(ID_FIELD_NAME.concat(":*"));
        } else if (collection.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder(collection.size() * 10);
            stringBuilder.append(ID_FIELD_NAME).append(":(");
            boolean first = true;
            for (String id : collection) {
                if (!first) {
                    stringBuilder.append(',');
                } else {
                    first = false;
                }
                stringBuilder.append(id);
            }
            stringBuilder.append(')');
            solrServer.deleteByQuery(stringBuilder.toString());
        }
    }

    private void commit() throws IOException, SolrServerException {
        logger.info("Commiting the changes to Solr");

        solrServer.commit();
    }

    private void commit(List<SolrInputDocument> docs) throws IOException, SolrServerException {
        logger.info("Commiting the changes to Solr");
        UpdateRequest req = new UpdateRequest();
        req.setAction(UpdateRequest.ACTION.COMMIT, false, false);
        req.add(docs);
        req.process(solrServer);
    }
}

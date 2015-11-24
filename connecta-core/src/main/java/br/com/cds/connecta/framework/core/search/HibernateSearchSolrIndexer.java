package br.com.cds.connecta.framework.core.search;

import org.apache.lucene.document.Document;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.hibernate.search.backend.*;
import org.hibernate.search.backend.spi.BackendQueueProcessor;
import org.hibernate.search.spi.WorkerBuildContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.index.IndexableField;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.hibernate.search.indexes.spi.DirectoryBasedIndexManager;

/**
 * Backend processor para indexar os dados no Solr ao inves do Lucene
 *
 * FIXME Less if, more power http://antiifcampaign.com/
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class HibernateSearchSolrIndexer implements BackendQueueProcessor {

    private static final String ID_FIELD_NAME = "id";

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static final Logger logger = Logger.getLogger(HibernateSearchSolrIndexer.class.getName());
    private static final String SOLR_INDEX_ROOT_PROP = "connecta.search.solrbackend";

    private HttpSolrServer solrServer;

    @Override
    public void initialize(Properties properties, WorkerBuildContext workerBuildContext, DirectoryBasedIndexManager directoryBasedIndexManager) {
        try {
            Properties props = new Properties();

            props.load(getClass().getClassLoader().getResourceAsStream("application.properties"));

            solrServer = new HttpSolrServer(props.getProperty(SOLR_INDEX_ROOT_PROP));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void close() {
        solrServer.shutdown();
        logger.info("Closing.");
    }

    @Override
    public void applyWork(List<LuceneWork> luceneWorks, IndexingMonitor indexingMonitor) {
        List<SolrInputDocument> solrWorks = new ArrayList<>(luceneWorks.size());
        List<String> documentsForDeletion = new ArrayList<>();

        boolean purgeAll = false;

        for (LuceneWork work : luceneWorks) {
            SolrInputDocument solrInputDocument = null;

            logger.log(Level.INFO, "Running Lucene work: {0}", work);

            if (work instanceof AddLuceneWork) {
                solrInputDocument = new SolrInputDocument();
                handleAddLuceneWork((AddLuceneWork) work, solrInputDocument);
            } else if (work instanceof UpdateLuceneWork) {
                solrInputDocument = new SolrInputDocument();
                handleUpdateLuceneWork((UpdateLuceneWork) work, solrInputDocument);
            } else if (work instanceof DeleteLuceneWork) {
                solrInputDocument = new SolrInputDocument();
                documentsForDeletion.add(((DeleteLuceneWork) work).getIdInString());
            } else if (work instanceof PurgeAllLuceneWork) {
                purgeAll = true;
            } else {
                logger.log(Level.SEVERE, "Unsupported LuceneWork: {0}", work);
            }

            if (solrInputDocument != null) {
                logger.log(Level.INFO, "Adding to queue Solr Work: {0}", solrInputDocument);
                solrWorks.add(solrInputDocument);
            }
        }
        try {
            deleteDocs(documentsForDeletion, purgeAll);

            if (solrWorks.size() > 0) {
                solrServer.add(solrWorks);
                commit(solrWorks);
            } else {
                commit();
            }
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException("Failed to update solr", e);
        }

    }

    /**
     * FIXME Refatorar pra não ficar duplicado
     * 
     * @param work
     * @param indexingMonitor 
     */
    @Override
    public void applyStreamWork(LuceneWork work, IndexingMonitor indexingMonitor) {
        logger.log(Level.INFO, "APPLY STREAM WORK", work);
        SolrInputDocument solrInputDocument = null;

        List<String> documentsForDeletion = new ArrayList<>();

        boolean purgeAll = false;

        if (work instanceof AddLuceneWork) {
            solrInputDocument = new SolrInputDocument();
            handleAddLuceneWork((AddLuceneWork) work, solrInputDocument);
        } else if (work instanceof UpdateLuceneWork) {
            solrInputDocument = new SolrInputDocument();
            handleUpdateLuceneWork((UpdateLuceneWork) work, solrInputDocument);
        } else if (work instanceof DeleteLuceneWork) {
            solrInputDocument = new SolrInputDocument();
            documentsForDeletion.add(((DeleteLuceneWork) work).getIdInString());
        } else if (work instanceof PurgeAllLuceneWork) {
            purgeAll = true;
        } else {
            logger.log(Level.SEVERE, "Unsupported LuceneWork: {0}", work);
        }
        
        try {
            deleteDocs(documentsForDeletion, purgeAll);

            solrServer.add(solrInputDocument);
            List<SolrInputDocument> solrWorks = new ArrayList<>(1);
            solrWorks.add(solrInputDocument);
            commit(solrWorks);
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException("Failed to update solr", e);
        }
    }

    @Override
    public Lock getExclusiveWriteLock() {
        return writeLock;
    }

    @Override
    public void indexMappingChanged() {
        logger.info("[UnsupportedOperation] Index mapping changed");
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
//            solrServer.deleteByQuery(stringBuilder.toString());
        }
    }

    private void copyFields(Document document, SolrInputDocument solrInputDocument) {
        boolean addedId = false;
        for (IndexableField fieldable : document.getFields()) {
            if (fieldable.name().equals(ID_FIELD_NAME)) {
                if (addedId) {
                    continue;
                } else {
                    addedId = true;
                }
            }
            solrInputDocument.addField(fieldable.name(), fieldable.stringValue());
        }
    }

    private void handleAddLuceneWork(AddLuceneWork luceneWork, SolrInputDocument solrWork) {
        copyFields(luceneWork.getDocument(), solrWork);
    }

    private void handleUpdateLuceneWork(UpdateLuceneWork luceneWork, SolrInputDocument solrWork) {
        copyFields(luceneWork.getDocument(), solrWork);
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

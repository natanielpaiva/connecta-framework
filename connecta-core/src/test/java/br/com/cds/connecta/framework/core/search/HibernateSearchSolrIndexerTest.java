package br.com.cds.connecta.framework.core.search;

import br.com.cds.connecta.framework.core.context.ConnectaConfigurationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.hibernate.search.backend.AddLuceneWork;
import org.hibernate.search.backend.DeleteLuceneWork;
import org.hibernate.search.backend.IndexingMonitor;
import org.hibernate.search.backend.LuceneWork;
import org.hibernate.search.backend.UpdateLuceneWork;
import org.hibernate.search.indexes.spi.DirectoryBasedIndexManager;
import org.hibernate.search.spi.WorkerBuildContext;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

/**
 *
 * @author Vinicius Pires
 */
@Ignore
public class HibernateSearchSolrIndexerTest {

    private final HibernateSearchSolrIndexer instance;
    
    public HibernateSearchSolrIndexerTest() {
        instance = new HibernateSearchSolrIndexer();
        ReflectionTestUtils.setField(instance, "solrServer", Mockito.mock(HttpSolrServer.class));
        ApplicationContext mock = Mockito.mock(ApplicationContext.class);
        Mockito.when(mock.getBean(ConnectaConfigurationService.class)).thenReturn(new ConnectaConfigurationService());
        instance.setApplicationContext(mock);
    }

    @Before
    public void before() {
        Properties properties = null;
        WorkerBuildContext workerBuildContext = null;
        DirectoryBasedIndexManager directoryBasedIndexManager = null;
        instance.initialize(properties, workerBuildContext, directoryBasedIndexManager);
    }

    @After
    public void after() {
        instance.close();
    }

    /**
     * Test of applyWork method, of class HibernateSearchSolrIndexer.
     */
    @Test
    public void testApplyWork() {
        List<LuceneWork> luceneWorks = makeLuceneWorks();
        
        IndexingMonitor indexingMonitor = null;
        instance.applyWork(luceneWorks, indexingMonitor);
    }

    /**
     * Test of applyStreamWork method, of class HibernateSearchSolrIndexer.
     */
    @Test
    public void testApplyStreamAddWork() {
        LuceneWork work = makeAddLuceneWork();
        IndexingMonitor indexingMonitor = null;
        instance.applyStreamWork(work, indexingMonitor);
    }
    
    @Test
    public void testApplyStreamUpdateWork() {
        LuceneWork work = makeUpdateLuceneWork();
        IndexingMonitor indexingMonitor = null;
        instance.applyStreamWork(work, indexingMonitor);
    }
    
    @Test
    public void testApplyStreamDeleteWork() {
        LuceneWork work = makeDeleteLuceneWork();
        IndexingMonitor indexingMonitor = null;
        instance.applyStreamWork(work, indexingMonitor);
    }

    /**
     * Test of indexMappingChanged method, of class HibernateSearchSolrIndexer.
     */
    @Test
    public void testIndexMappingChanged() {
        instance.indexMappingChanged();
    }
    
    private List<LuceneWork> makeLuceneWorks() {
        List<LuceneWork> luceneWorks = new ArrayList<>();
        luceneWorks.add(makeAddLuceneWork());
        luceneWorks.add(makeAddLuceneWork());
        luceneWorks.add(makeUpdateLuceneWork());
        luceneWorks.add(makeUpdateLuceneWork());
        luceneWorks.add(makeDeleteLuceneWork());
        luceneWorks.add(makeDeleteLuceneWork());
//        luceneWorks.add(makePurgeAllLuceneWork());
//        luceneWorks.add(makePurgeAllLuceneWork());
        return luceneWorks;
    }

    private AddLuceneWork makeAddLuceneWork() {
        Document document = new Document();
        document.add(new IntField("id", 1, Field.Store.YES));
        document.add(new StringField("name", "POTATO CHIPS!", Field.Store.YES));
        return new AddLuceneWork(1, "1", Object.class, document);
    }
    
    private UpdateLuceneWork makeUpdateLuceneWork() {
        Document document = new Document();
        document.add(new IntField("id", 1, Field.Store.YES));
        document.add(new StringField("name", "POTATO CHAPA!", Field.Store.YES));
        return new UpdateLuceneWork(1, "1", Object.class, document);
    }
    
    private DeleteLuceneWork makeDeleteLuceneWork() {
        DeleteLuceneWork deleteLuceneWork = new DeleteLuceneWork(1, "1", Object.class);
        
        return deleteLuceneWork;
    }
    
//    private PurgeAllLuceneWork makePurgeAllLuceneWork() {
//        return new PurgeAllLuceneWork(Object.class);
//    }

}

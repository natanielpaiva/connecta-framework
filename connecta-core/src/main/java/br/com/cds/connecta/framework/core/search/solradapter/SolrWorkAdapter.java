package br.com.cds.connecta.framework.core.search.solradapter;

import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.hibernate.search.backend.LuceneWork;

/**
 * Interface que faz a conversão de um Request de Lucene em Request de Solr
 * @author Vinicius Pires
 */
public interface SolrWorkAdapter {
    
    /**
     * Faz alterações no request para o Solr
     * @see br.com.cds.connecta.framework.core.search.HibernateSearchSolrIndexer
     * @param work work
     * @param idsForDeletion idsForDeletion
     * @param purgeAll purgeAll
     * @return return 
     */
    SolrInputDocument adaptRequest(LuceneWork work, List<String> idsForDeletion, Boolean purgeAll);
}

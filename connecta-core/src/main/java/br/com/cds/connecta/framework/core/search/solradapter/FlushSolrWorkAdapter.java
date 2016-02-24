package br.com.cds.connecta.framework.core.search.solradapter;

import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.hibernate.search.backend.LuceneWork;


public class FlushSolrWorkAdapter implements SolrWorkAdapter {

    @Override
    public SolrInputDocument adaptRequest(LuceneWork work, List<String> idsForDeletion, Boolean purgeAll) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

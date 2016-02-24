package br.com.cds.connecta.framework.core.search.solradapter;

import static br.com.cds.connecta.framework.core.search.solradapter.SolrWorkAdapterUtils.copyFields;
import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.hibernate.search.backend.LuceneWork;


public class UpdateSolrWorkAdapter implements SolrWorkAdapter {

    @Override
    public SolrInputDocument adaptRequest(LuceneWork work, List<String> idsForDeletion, Boolean purgeAll) {
        SolrInputDocument solrInputDocument = new SolrInputDocument();
        copyFields(work.getDocument(), solrInputDocument);
        return solrInputDocument;
    }

}

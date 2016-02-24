package br.com.cds.connecta.framework.core.search.solradapter;

import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.hibernate.search.backend.LuceneWork;


public class DeleteSolrWorkAdapter implements SolrWorkAdapter {


    @Override
    public SolrInputDocument adaptRequest(LuceneWork work, List<String> idsForDeletion, Boolean purgeAll) {
        SolrInputDocument solrInputDocument = new SolrInputDocument();
        solrInputDocument.addField(SolrWorkAdapterUtils.ID_FIELD_NAME, work.getId());
        idsForDeletion.add(work.getIdInString());
        return solrInputDocument;
    }

}

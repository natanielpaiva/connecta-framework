package br.com.cds.connecta.framework.core.search.solradapter;

import static br.com.cds.connecta.framework.core.search.solradapter.SolrWorkAdapterUtils.*;
import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.hibernate.search.backend.LuceneWork;

public class AddSolrWorkAdapter implements SolrWorkAdapter {

    @Override
    public SolrInputDocument adaptRequest(LuceneWork work, List<String> idsForDeletion, Boolean purgeAll) {
        SolrInputDocument solrInputDocument = new SolrInputDocument();
        // FIXME Alterar o ID do documento com o nome da classe
        copyFields(work.getDocument(), solrInputDocument);
        addModuleFieldIfViewer(work, solrInputDocument);
        
        return solrInputDocument;
    }

}

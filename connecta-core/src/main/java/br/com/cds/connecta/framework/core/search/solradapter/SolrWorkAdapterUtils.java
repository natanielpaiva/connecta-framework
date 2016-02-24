package br.com.cds.connecta.framework.core.search.solradapter;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexableField;
import org.apache.solr.common.SolrInputDocument;
import org.hibernate.search.backend.*;
import org.hibernate.search.backend.spi.DeleteByQueryLuceneWork;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class SolrWorkAdapterUtils {
    
    public static final String ID_FIELD_NAME = "id";
    private static final Logger logger = Logger.getLogger(SolrWorkAdapterUtils.class.getName());
    private static final Map<Class<? extends LuceneWork>, Class<? extends SolrWorkAdapter>> adapters;

    static {
        adapters = new HashMap<>();
        adapters.put(AddLuceneWork.class, AddSolrWorkAdapter.class);
        adapters.put(UpdateLuceneWork.class, UpdateSolrWorkAdapter.class);
        adapters.put(DeleteLuceneWork.class, DeleteSolrWorkAdapter.class);
        adapters.put(DeleteByQueryLuceneWork.class, DeleteByQuerySolrWorkAdapter.class);
        
        adapters.put(PurgeAllLuceneWork.class, PurgeAllSolrWorkAdapter.class);
        adapters.put(FlushLuceneWork.class, FlushSolrWorkAdapter.class);
        adapters.put(OptimizeLuceneWork.class, OptimizeSolrWorkAdapter.class);
    }
    
    public static void copyFields(Document document, SolrInputDocument solrInputDocument) {
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
    
    public static SolrWorkAdapter getSolrWorkAdapter(LuceneWork work) {
        SolrWorkAdapter adapter = null;
        
        try {
            adapter = adapters.get(work.getClass()).newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            logger.log(Level.SEVERE, "Unsupported LuceneWork: {0}", work.getClass().getCanonicalName());
        }
        
        return adapter;
    }

}

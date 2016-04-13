package br.com.cds.connecta.framework.connector2.common;

import org.apache.metamodel.DataContext;

/**
 *
 * @author diego
 */
public class Base {

    protected DataContext dataContext = null;

    protected QueryContext queryContext = null;
    
    public DataContext createDataContext() {
        return dataContext;
    }
    
    public QueryContext getQueryContext() {
        return queryContext;
    }

    public void setQueryContext(QueryContext queryContext) {
        this.queryContext = queryContext;
    }
    
    public DataContext getDataContext() {
        return dataContext;
    }
}

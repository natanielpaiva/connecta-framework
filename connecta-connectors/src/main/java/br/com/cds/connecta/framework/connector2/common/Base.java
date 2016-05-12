package br.com.cds.connecta.framework.connector2.common;

import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import org.apache.metamodel.DataContext;

/**
 *
 * @author diego
 */
public class Base {

    protected DataContext dataContext = null;

    protected QueryBuilder queryContext = null;
    
    //verificar a possibilidade de pagar esse método
    public DataContext createDataContext() {
        return dataContext;
    }
    
    public QueryBuilder getQueryContext() {
        return queryContext;
    }

    public void setQueryContext(QueryBuilder queryContext) {
        this.queryContext = queryContext;
    }
    
    public DataContext getDataContext() {
        return dataContext;
    }
}

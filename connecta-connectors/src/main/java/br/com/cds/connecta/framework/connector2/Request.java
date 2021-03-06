package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import java.util.List;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.schema.Column;

/**
 * 
 *
 * @author diego
 */
public class Request {

    private final ContextFactory dataContextFactory;
    private QueryBuilder queryContext;

    public Request(ContextFactory dataContextFactory) {
        this.dataContextFactory = dataContextFactory;
    }

    public Request(ContextFactory dataContextFactory, QueryBuilder queryContext) {
        this.queryContext = queryContext;
        this.dataContextFactory = dataContextFactory;
    }

    public ContextFactory getDataContextFactory() {
        return dataContextFactory;
    }
    
    public DataContext getDataContext() {
        DataContext dataContext = dataContextFactory.createDataContext();
        dataContextFactory.setQueryContext(queryContext);
        return dataContext;
    }
    
    public QueryBuilder getQueryContext() {
        return queryContext;
    }

    public DataSet getResultAll() {
        dataContextFactory.setQueryContext(queryContext);
        dataContextFactory.createDataContext();

        return dataContextFactory.getResultAll();
    }

    public List<ConnectorColumn> getColumns() {
        dataContextFactory.createDataContext();
        dataContextFactory.setQueryContext(queryContext);

        return dataContextFactory.getColumns();
    }
    public Column getColumn(String nameColumn) {
        dataContextFactory.createDataContext();
        dataContextFactory.setQueryContext(queryContext);

        return dataContextFactory.getColumn(nameColumn);
    }
    
}

package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.CompositeDataContextFactory;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.QueryContext;
import java.util.List;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.query.FilterItem;
import org.apache.metamodel.query.OperatorType;
import org.apache.metamodel.schema.Column;

/**
 * gardem
 *
 * @author diego
 */
public class Request {

    public ContextFactory dataContextFactory;

    public QueryContext queryContext;

    public Request(ContextFactory dataContextFactory) {
        this.dataContextFactory = dataContextFactory;
    }

    public Request(ContextFactory dataContextFactory, QueryContext queryContext) {
        this.queryContext = queryContext;
        this.dataContextFactory = dataContextFactory;
    }

    public DataContext getDataContextFactory() {
        DataContext dataContext = dataContextFactory.createDataContext();
        dataContextFactory.setQueryContext(queryContext);
        return dataContext;
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
    
//    public DataSet getResultApplyingFilter(String column, String condition){
//        dataContextFactory.createDataContext();
//        Column column1 = dataContextFactory.getColumn(column);
//        
//        queryContext.getColumnWhere(column1);
//        queryContext.getQuery().where(column1, OperatorType.EQUALS_TO, condition);
//        return dataContextFactory.getResultAll();
//    }

    
    
//    public Request(ContextFactory leftDataContext, ContextFactory rightContextFactory, QueryContext queryContext) {
//        this.queryContext = queryContext;
//        dataContextFactory = new CompositeDataContextFactory(leftDataContext, rightContextFactory);
//         //dataContextFactory.setQueryContext(queryContext);
//    }
    
    
//    public Request(QueryContext queryContext) {
//        this.queryContext = queryContext;
//        //dataContextFactory = new CompositeDataContextFactory();
//         //dataContextFactory.setQueryContext(queryContext);
//    }


}

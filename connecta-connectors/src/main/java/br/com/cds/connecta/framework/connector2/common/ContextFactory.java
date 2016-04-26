package br.com.cds.connecta.framework.connector2.common;

import java.util.List;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;

/**
 *
 * @author diego
 */
public interface ContextFactory {

    DataContext createDataContext();

    DataSet getResultAll();

    List<ConnectorColumn> getColumns();

    void setQueryContext(QueryBuilder queryContext);
    
    Table getTable();
    
    Column getColumn(String columnName);

    DataContext getDataContext();
    
    String[] getSchemas();
    
    String[] getTables();
    
}

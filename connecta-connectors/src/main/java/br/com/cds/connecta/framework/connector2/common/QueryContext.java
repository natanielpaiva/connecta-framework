package br.com.cds.connecta.framework.connector2.common;

import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.apache.metamodel.query.FunctionType;
import org.apache.metamodel.query.OperatorType;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;

/**
 *
 * @author diego
 */
public class QueryContext {
    
   // DataContext dataContext;
    
    Query query = new Query();
    
    String table;
    
    String schema;
    
    String[] columns;

    String foreignKey, primaryKey; 
             
    List<ConnectorColumn> connectorColumns;
    
    //provisorio
    ContextFactory leftContextFactory, rightContextFactory;
    
//    public String[] getColumns() {
//        return columns;
//    }

//    public QueryContext setColumns(String[] columns) {
//        this.columns = columns;
//        return this;
//    }
    
    
    public QueryContext setColumns( List<ConnectorColumn>  connectorColumns) {
        this.connectorColumns = connectorColumns;
        return this;
    }
    
    public List<ConnectorColumn> getColumns() {
        return connectorColumns;
    }
    

    public QueryContext setTable(String table) {
        this.table = table;
        return this;
    }

    public String getTable() {
        return table;
    }

    public String getSchema() {
        return schema;
    }

    public QueryContext setSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public List<ConnectorColumn> getConnectorColumns() {
        return connectorColumns;
    }

    
    public QueryContext setConnectorColumns(List<ConnectorColumn> connectorColumns) {
        this.connectorColumns = connectorColumns;
       
        return this;
    }
    
    public QueryContext setPagination(int start, int size){
        this.query.setFirstRow(start).setMaxRows(size);
        return this;
    }
    
    public QueryContext setColumnWhere(Column column, String condition){
        this.query.where(column, OperatorType.EQUALS_TO, condition);
        return this;
    }
    
    public QueryContext setGroupBy(Column column){
        this.query.select(column);
        this.query.groupBy(column);
        
         System.out.println("-----------" + this.query.toString());
        return this;
    }
    
    public QueryContext setCount(Column column){
        
        this.query.select(FunctionType.SUM, column);
        
//        .select(FunctionType.AVG, getColumn("funcionario"))
//                    .select(getColumn("nome"))
//                    .groupBy("nome"));
        
//         DataSet executeQuery = dataContext.executeQuery(queryContext.getQuery().select(FunctionType.COUNT, getColumn("funcionario")).select(getColumn("nome")).groupBy("nome"));

        return this;
    }
    
    public QueryContext setColumn(Column column){
        this.query.select(column);
        return this;
    }
    
    
    public Query getQuery(){
        return query;
    }
    
    public QueryContext getQueryContext(){
        return this;
    }


 
}

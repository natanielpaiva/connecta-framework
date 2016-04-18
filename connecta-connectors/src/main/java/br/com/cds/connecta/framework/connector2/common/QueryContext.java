package br.com.cds.connecta.framework.connector2.common;

import java.util.List;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.query.JoinType;
import org.apache.metamodel.query.Query;

/**
 *
 * @author diego
 */
public class QueryContext {
    
    DataContext dataContext;
    
    Query query = new Query();
    
    String table;
    
    String schema;
    
    String[] columns;

    String foreignKey, primaryKey; 
             
    List<ConnectorColumn> connectorColumn;
    
    //provisorio
    ContextFactory leftContextFactory, rightContextFactory;
    
    public String[] getColumns() {
        return columns;
    }

    public QueryContext setColumns(String[] columns) {
        this.columns = columns;
        return this;
    }
    
    public List<ConnectorColumn> getConnectorColumn() {
        return connectorColumn;
    }

    public void setConnectorColumn(List<ConnectorColumn> connectorColumn) {
        this.connectorColumn = connectorColumn;
        
    }

    
    public QueryContext() {
        System.out.println("Contrutor QueryContext");
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
    
    public QueryContext setPagination(int start, int size){
        this.query.setFirstRow(start).setMaxRows(size);
        return this;
    }
    
    
    
    
    
    
    public Query getQuery(){
        return query;
    }
    
    public QueryContext getQueryContext(){
        return this;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public QueryContext setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
        return this;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public QueryContext setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
        return this;
    }
    
    
    
//   public QueryContext creatJoin(ContextFactory leftContextFactory, ContextFactory rightContextFactory ){
//       this.leftContextFactory = leftContextFactory;
//       this.rightContextFactory = rightContextFactory;
//       
//       this.query.from(leftContextFactory.getTable(),
//                    rightContextFactory.getTable(),
//                    JoinType.LEFT,
//                    leftContextFactory.getKey(),
//                    rightContextFactory.getKey());
//        return this;
//       
//   }

    public ContextFactory getLeftContextFactory() {
        return leftContextFactory;
    }

    public void setLeftContextFactory(ContextFactory leftContextFactory) {
        this.leftContextFactory = leftContextFactory;
    }

    public ContextFactory getRightContextFactory() {
        return rightContextFactory;
    }

    public void setRightContextFactory(ContextFactory rightContextFactory) {
        this.rightContextFactory = rightContextFactory;
    }
   
   
   
   
    
}

package br.com.cds.connecta.framework.connector2.query;

import br.com.cds.connecta.framework.connector2.common.CompositeJoin;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.metamodel.query.FromItem;
import org.apache.metamodel.query.FunctionType;
import org.apache.metamodel.query.JoinType;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.SelectItem;
import org.apache.metamodel.schema.Column;

/**
 *
 * @author diego
 */
public class QueryBuilder {
    
    private static final Logger logger = Logger.getLogger(QueryBuilder.class);

    private final Query query = new Query();
    private String table;
    private String schema;
    private List<ConnectorColumn> columns;
    
    private Column leftColumn;
    private String leftAlias;
    
    private Column rightColumn;
    private String rightAlias;

    
    public QueryBuilder setColumns(List<ConnectorColumn> columns) {
        this.columns = columns;
        return this;
    }

    public List<ConnectorColumn> getColumns() {
        return columns;
    }

    public QueryBuilder setTable(String table) {
        this.table = table;
        return this;
    }

    public String getTable() {
        return table;
    }

    public String getSchema() {
        return schema;
    }

    public QueryBuilder setSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public List<ConnectorColumn> getConnectorColumns() {
        return columns;
    }

    public QueryBuilder setPagination(int start, int size) {
        this.query.setFirstRow(start).setMaxRows(size);
        return this;
    }
    
    public QueryBuilder addFilter(Column column, QueryFilterOperator filterOperator, QueryFilterValue value) {
        filterOperator.transformQuery(query, column, value);
        return this;
    }

    public QueryBuilder addGroupBy(Column column) {
        this.query.select(column);
        this.query.groupBy(column);
        
        return this;
    }

    public QueryBuilder addCount(Column column) {
        this.query.select(FunctionType.COUNT, column);
        return this;
    }

    public QueryBuilder addColumn(Column column) {
        this.query.select(column);
        return this;
    }
    
    public QueryBuilder addSum(Column column) {
        this.query.select(FunctionType.SUM, column);
        return this;
    }
    
//    public QueryBuilder addJoin(Column leftColumn, JoinType joinType, Column rightColumn) {
//        
//         FromItem fromItem = new FromItem(joinType,
//                   new FromItem (leftColumn.getTable()).setAlias("A"),
//                   new FromItem(rightColumn.getTable()).setAlias("B"),
//                   new SelectItem[]{new SelectItem(leftColumn)},
//                   new SelectItem[]{new SelectItem(rightColumn)});
//         
//         this.query.from(fromItem);
//        
//        return this;
//    }
    
//     public QueryBuilder addJoin(Column leftColumn, String leftAlias, JoinType joinType, Column rightColumn, String rightAlias) {
//        this.leftColumn = leftColumn;
//        this.leftAlias = leftAlias;
//        this.rightColumn = rightColumn;
//        this.rightAlias = rightAlias;
//         
//         FromItem fromItem = new FromItem(joinType,
//                   new FromItem (leftColumn.getTable()).setAlias(leftAlias),
//                   new FromItem(rightColumn.getTable()).setAlias(rightAlias),
//                   new SelectItem[]{new SelectItem(leftColumn)},
//                   new SelectItem[]{new SelectItem(rightColumn)});
//         
//         this.query.from(fromItem);
//        
//        return this;
//    }

     
    public String getLeftAlias() {
        return leftAlias;
    }

    public void setLeftAlias(String leftAlias) {
        this.leftAlias = leftAlias;
    }

    public String getRightAlias() {
        return rightAlias;
    }

    public void setRightAlias(String rightAlias) {
        this.rightAlias = rightAlias;
    } 
     
    public Column getLeftColumn() {
        return leftColumn;
    }

    public void setLeftColumn(Column leftColumn) {
        this.leftColumn = leftColumn;
    }

    public Column getRightColumn() {
        return rightColumn;
    }

    public void setRightColumn(Column rightColumn) {
        this.rightColumn = rightColumn;
    }
   
    

    public Query build() {
        logger.info("QUERY BUILT: "+query);
        return query;
    }
    
    public QueryBuilder addOrder(Column column){
        this.query.orderBy(column);
        return this;
    }
    
}

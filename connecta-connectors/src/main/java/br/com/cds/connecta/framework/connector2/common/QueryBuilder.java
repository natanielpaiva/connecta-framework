package br.com.cds.connecta.framework.connector2.common;

import java.util.List;
import org.apache.log4j.Logger;
import org.apache.metamodel.query.FunctionType;
import org.apache.metamodel.query.OperatorType;
import org.apache.metamodel.query.Query;
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
    

//    private String[] columns;
//    private String foreignKey, primaryKey; 
//    private ContextFactory leftContextFactory, rightContextFactory;
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

    public QueryBuilder addWhere(Column column, OperatorType operator, Object condition) {
        this.query.where(column, operator, condition);
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

    public Query build() {
        logger.info("QUERY BUILT: "+query);
        return query;
    }

}
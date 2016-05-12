package br.com.cds.connecta.framework.connector2.query;

import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.metamodel.query.FunctionType;
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

    public Query build() {
        logger.info("QUERY BUILT: "+query);
        return query;
    }
    
}

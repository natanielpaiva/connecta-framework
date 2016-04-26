package br.com.cds.connecta.framework.connector2.common;

import org.apache.metamodel.schema.Column;

/**
 *
 * @author diego
 */
public class CompositeJoin {

    QueryBuilder queryContext;

    ContextFactory leftContextFactory, rightContextFactory;
    
    Column leftColumn, rightColumn; 

    public CompositeJoin(ContextFactory leftContextFactory, String leftColumn,ContextFactory rightContextFactory,  String rightColumn) {
        this.leftContextFactory = leftContextFactory;
        this.leftColumn = leftContextFactory.getColumn(leftColumn);
        this.rightContextFactory = rightContextFactory;
        this.rightColumn = rightContextFactory.getColumn(rightColumn);
    }

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

    public Column getLeftColumn() {
        return leftColumn;
    }

    public Column getRightColumn() {
        return rightColumn;
    }
    

    public QueryBuilder getQueryContext() {
        return queryContext;
    }

    public void setQueryContext(QueryBuilder queryContext) {
        this.queryContext = queryContext;
    }
}

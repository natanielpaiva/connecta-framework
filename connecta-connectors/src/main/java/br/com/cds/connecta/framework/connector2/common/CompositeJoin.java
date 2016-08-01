package br.com.cds.connecta.framework.connector2.common;

import org.apache.metamodel.query.JoinType;
import org.apache.metamodel.schema.Column;

/**
 *
 * @author diego
 */
public class CompositeJoin {

    ContextFactory contextFactory;
    
    Column column; 
    
    String alias;
    
    JoinType joinType;
    
    public CompositeJoin(ContextFactory contextFactory, String column, String alias,
                    JoinType joinType) {
        this.contextFactory = contextFactory;
        this.column = contextFactory.getColumn(column);
        this.alias = alias;
        this.joinType = joinType;
        
    }
    
    public ContextFactory getContextFactory() {
        return contextFactory;
    }

    public void setContextFactory(ContextFactory contextFactory) {
        this.contextFactory = contextFactory;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public JoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }
}

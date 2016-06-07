package br.com.cds.connecta.framework.connector2.query;

import org.apache.metamodel.query.OperatorType;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.SelectItem;
import org.apache.metamodel.schema.Column;

/**
 *
 * @author diego
 */
public enum QueryFilterOperator {
    EQUAL {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.EQUALS_TO, value.getValue());
        }
    },
    NOT_EQUAL {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.DIFFERENT_FROM, value.getValue());
        }
    },
    LESS_THAN {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.LESS_THAN, value.getValue());
        }
    },
    LESS_THAN_EQUAL {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.LESS_THAN_OR_EQUAL, value.getValue());
        }
    },
    GREATER_THAN {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.GREATER_THAN, value.getValue());
        }
    },
    GREATER_THAN_EQUAL {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.GREATER_THAN_OR_EQUAL, value.getValue());
        }
    },
    BETWEEN {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.GREATER_THAN_OR_EQUAL, value.getBetween().getStart());
            applyWhereOrHaving(query,column, OperatorType.LESS_THAN_OR_EQUAL, value.getBetween().getEnd());
        }
    },
    IN {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.IN, value.getIn());
        }
    },
    CONTAINS {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.LIKE, "%"+value.getValue()+"%");
        }
    },
    STARTS_WITH {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.LIKE, value.getValue()+"%");
        }
    },
    ENDS_WITH {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            applyWhereOrHaving(query,column, OperatorType.LIKE, "%"+value.getValue());
        }
    };

    abstract void transformQuery(Query query, Column column, QueryFilterValue value);
    
    /*
     * Decide se vai ser aplicado Where ou Having
     * Caso tenha um drill aplicado ( consigo identificar por uma function no select ( SUM ) )
     * deve ser usado HAVING, caso contrário o filtro será utilizado linha por linha, 
     * informando um resultado errôneo.
     */
    void applyWhereOrHaving(Query query, Column column, OperatorType operator, Object value){
        if(query.getSelectClause() != null) {
            for (SelectItem item : query.getSelectClause().getItems()) {
                /*
                 * Caso tenha uma função aplicada na mesma coluna
                 */
                if(item.getFunction() != null
                        && item.getColumn().getName().equals(column.getName())){
                    query.having(column, operator, value);
                    return;
                }
            }
        }
        query.where(column, operator, value);
    }
    
}

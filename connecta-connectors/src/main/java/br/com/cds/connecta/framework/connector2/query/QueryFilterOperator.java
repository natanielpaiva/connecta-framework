package br.com.cds.connecta.framework.connector2.query;

import org.apache.metamodel.query.FilterItem;
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
            query.where(column, OperatorType.EQUALS_TO, value.getValue());
        }
    },
    NOT_EQUAL {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            query.where(column, OperatorType.DIFFERENT_FROM, value.getValue());
        }
    },
    LESS_THAN {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            query.where(column, OperatorType.LESS_THAN, value.getValue());
        }
    },
    LESS_THAN_EQUAL {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            query.where(column, OperatorType.LESS_THAN_OR_EQUAL, value.getValue());
        }
    },
    GREATER_THAN {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            query.where(column, OperatorType.GREATER_THAN, value.getValue());
        }
    },
    GREATER_THAN_EQUAL {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            query.where(column, OperatorType.GREATER_THAN_OR_EQUAL, value.getValue());
        }
    },
    BETWEEN {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            query.where(column, OperatorType.GREATER_THAN_OR_EQUAL, value.getBetween().getStart());
            query.where(column, OperatorType.LESS_THAN_OR_EQUAL, value.getBetween().getEnd());
        }
    },
    IN {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            query.where(column, OperatorType.IN, value.getIn());
        }
    },
    CONTAINS {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            query.where(column, OperatorType.LIKE, "%"+value.getValue()+"%");
        }
    },
    STARTS_WITH {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            query.where(column, OperatorType.LIKE, value.getValue()+"%");
        }
    },
    ENDS_WITH {
        @Override
        void transformQuery(Query query, Column column, QueryFilterValue value) {
            query.where(column, OperatorType.LIKE, "%"+value.getValue());
        }
    };

    abstract void transformQuery(Query query, Column column, QueryFilterValue value);
    
}

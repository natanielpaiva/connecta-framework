package br.com.cds.connecta.framework.connector2.query;

import java.util.List;

/**
 *
 * @author diego
 * @param <T>
 */
public class QueryFilterValue<T extends Object> {
    
    private T value;
    private List<T> in;
    private QueryFilterValueBetween between;

    public QueryFilterValue() {}

    public QueryFilterValue(T value) {
        this.value = value;
    }
    
    public QueryFilterValue(List<T> in) {
        this.in = in;
    }
    
    public QueryFilterValue(QueryFilterValueBetween between) {
        this.between = between;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<T> getIn() {
        return in;
    }

    public void setIn(List<T> in) {
        this.in = in;
    }

    public QueryFilterValueBetween getBetween() {
        return between;
    }

    public void setBetween(QueryFilterValueBetween between) {
        this.between = between;
    }
    
}

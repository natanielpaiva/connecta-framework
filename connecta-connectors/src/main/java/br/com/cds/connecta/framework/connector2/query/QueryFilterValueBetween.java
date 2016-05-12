package br.com.cds.connecta.framework.connector2.query;

/**
 *
 * @author diego
 * @param <T>
 */
public class QueryFilterValueBetween<T extends Object> {

    private T start;
    private T end;

    public QueryFilterValueBetween() {}

    public QueryFilterValueBetween(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        this.end = end;
    }
}

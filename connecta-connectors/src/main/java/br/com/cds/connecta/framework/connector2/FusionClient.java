package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.SelectItem;

/**
 *
 * @author diego
 */
public class FusionClient {

    /**
     * Retorna contexto do connector
     *
     * @param request
     * @return
     */
    public DataContext getDataContext(Request request) {
        DataContext dataContext = request.getDataContextFactory();
        return dataContext;
    }

    /**
     * Retorna Todos os dados de um context
     *
     * @param request
     * @return
     */
    public List<Map<String, Object>> getAll(Request request) {

        DataSet resultAll = request.getResultAll();
        return toList(resultAll, request.queryContext.getColumns());
    }

    /**
     * Retorna os metadados das columans
     *
     * @param request
     * @return
     */
    public List<ConnectorColumn> getColumns(Request request) {
        List<ConnectorColumn> columns = request.getColumns();
        return columns;
    }
    
    public boolean isValid(Request request) {
        return true;
    }

    public static List<Map<String, Object>> toList(DataSet execute, List<ConnectorColumn> columns) throws IndexOutOfBoundsException {

        List<Map<String, Object>> list = new ArrayList<>();

        for (Row row : execute) {
            SelectItem[] selectItems = row.getSelectItems();
            Map<String, Object> object = new HashMap<>(selectItems.length);

            for (int i = 0; i < row.getValues().length; i++) {

                if (columns != null) {
                    for (ConnectorColumn column : columns) {

                        if (column.getName().equals(selectItems[i].getColumn().getName())) {
                            String key = column.getLabel();
                            String value = row.getValue(i) == null ? "" : row.getValue(i).toString();
                            object.put(key, value);
                        }
                    }

                } else {
                    String key = selectItems[i].getColumn().getName();
                    String value = row.getValue(i) == null ? "" : row.getValue(i).toString();
                    object.put(key, value);
                }

            }

            list.add(object);
        }
        return list;
    }

}

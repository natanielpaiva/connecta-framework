package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.SelectItem;
import org.apache.metamodel.schema.Column;

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
        DataContext dataContext = request.getDataContext();
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
        
        return toList(resultAll, request.getQueryContext().getColumns());
    }

    public List<Object> possibleValuesFor(Request request, String columnName) {
        Column column = request.getDataContextFactory().getColumn(columnName);
        
        return possibleValuesFor(request, column);
    }
    
    public List<Object> possibleValuesFor(Request request, Column column) {
        request.getQueryContext()
                .setColumns(new ArrayList<ConnectorColumn>(0))
                .addGroupBy(column);

        DataSet resultAll = request.getResultAll();
        List<Map<String, Object>> list = toList(resultAll, null);

        PrintResult.printMap(list);

        List<Object> values = new ArrayList<>();

        for (Map<String, Object> map : list) {
            values.add(map.get(column.getName()));
        }

        return values;
    }

    /**
     * Retorna os metadados das colunas
     *
     * @param request
     * @return
     */
    public List<ConnectorColumn> getColumns(Request request) {
        List<ConnectorColumn> columns = request.getColumns();
        return columns;
    }

    /**
     * FIXME implementar
     *
     * @param request
     * @return
     */
    public boolean isValid(Request request) {
        return true;
    }

    public static List<Map<String, Object>> toList(DataSet execute, List<ConnectorColumn> columns) {
        List<Map<String, Object>> list = new ArrayList<>();

        for (Row row : execute) {   // Linhas
            SelectItem[] selectItems = row.getSelectItems();
            Map<String, Object> object = new LinkedHashMap<>(selectItems.length);

            for (int i = 0; i < selectItems.length; i++) {  // Colunas
                String columnLabel = null;
                Object value = row.getValue(i);

                if (value instanceof Blob) {
                    value = "(BINARY)";
                }

                // Caso não tenha colunas informadas, pega da definição do select
                if (columns == null) {
                    columnLabel = selectItems[i].getColumn().getName();
                } else {
                    for (ConnectorColumn column : columns) {
                        if (column.getName().equals(selectItems[i].getColumn().getName())) {
                            columnLabel = column.getLabel();
                        }
                    }
                }

                object.put(columnLabel, value);
            }
            
            list.add(object);
        }

        return list;
    }

}

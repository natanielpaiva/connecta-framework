package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import java.util.ArrayList;
import java.util.HashMap;
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
        return toList(resultAll, request.getQueryContext().getColumns());
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
//                            String key = column.getLabel();
//                            String value = row.getValue(i) == null ? "" : row.getValue(i).toString();
//                            object.put(key, value);
                            object.put(
                                column.getLabel(),
                                row.getValue(i)
                            );
                        }
                    }

                } else {
                    object.put(
                        selectItems[i].getColumn().getName(),
                        row.getValue(i)
                    );
                }

            }

            list.add(object);
        }
        return list;
    }

}

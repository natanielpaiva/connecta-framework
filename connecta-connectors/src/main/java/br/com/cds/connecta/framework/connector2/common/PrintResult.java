package br.com.cds.connecta.framework.connector2.common;

import dnl.utils.text.table.TextTable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author diego
 */
public class PrintResult {

    private PrintResult() {
    }

    public static void printMap(List<Map<String, Object>> result) {
        System.out.println("---------Result--------------");

        // Previne NullPointer e ArrayIndexOutOfBounds
        if (result == null || result.isEmpty()) {
            return;
        }

        Set<String> columns = result.get(0).keySet();
        String[] columnsName = new String[columns.size()];

        int c = 0;
        for (String column : columns) {
            columnsName[c] = column;
            c++;
        }

        Object[][] data = new Object[result.size()][columns.size()];

        for (int i = 0; i < result.size(); i++) {

            Map<String, Object> map = result.get(i);

            for (int j = 0; j < columnsName.length; j++) {
                if( map.get( columnsName[j] ) != null) {
                    data[i][j] = map.get(columnsName[j]).toString();
                } else {
                    data[i][j] = "null";
                }
            }

        }

        TextTable dd = new TextTable(columnsName, data);
        dd.printTable();
    }

    public static void printColumns(List<ConnectorColumn> connectorColumns) {
        System.out.println("---------ConnectorColumns--------------");
        String[] columnNames = {"Name", "Label", "Formula", "Type"};

        Object[][] data = new Object[connectorColumns.size()][4];
        for (int i = 0; i < connectorColumns.size(); i++) {
            ConnectorColumn cc = connectorColumns.get(i);

            data[i][0] = cc.getName();
            data[i][1] = cc.getLabel();
            data[i][2] = cc.getFormula();
            data[i][3] = cc.getType();
        }

        TextTable dd = new TextTable(columnNames, data);
        dd.printTable();
    }

    public static void printArrayString(String[] list) {
        System.out.println("--------- list--------------");
        String[] columnNames = {"Name"};

        Object[][] data = new Object[list.length][1];
        for (int i = 0; i < list.length; i++) {
            data[i][0] = list[i];
        }

        TextTable dd = new TextTable(columnNames, data);
        dd.printTable();
    }

}

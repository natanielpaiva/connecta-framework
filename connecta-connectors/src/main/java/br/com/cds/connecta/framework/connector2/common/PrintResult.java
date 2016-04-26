
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

//    public static void printMap(List<Map<String, Object>> result) {
//        System.out.println("\n");
//        Set<String> columns = result.get(0).keySet();
//        String parametros = "";
//
//        for (int i = 0; i < columns.size(); i++) {
//            parametros += "%-30s";
//            System.out.print("+----------------------------");
//        }
//
//        System.out.println("\r");
//        System.out.printf(parametros, columns.toArray());
//        System.out.println("\r");;
//        for (Map<String, Object> result1 : result) {
//
//            String value = "";
//            for (String column : columns) {
//                String format = String.format("%.20s", "|" + result1.get(column));
//
//                value += value.format("%-30s", format);
//            }
//
//            System.out.println(value);
//        }
//    }

        
    public static void printMap(List<Map<String, Object>> result){
        System.out.println("---------Result--------------");
        
        Set<String> columns = result.get(0).keySet();
        String[] columnsName = new String[columns.size()];

        int c = 0;
        for (String column : columns) {
            columnsName[c] = column;
            c++;
        }
        
        Object[][] data = new Object[result.size()][columns.size()];
        
        for (int i = 0; i < result.size(); i++) {
            
            Map<String, Object> get = result.get(i);

            for (int j = 0; j < columnsName.length; j++) {
                        
                 data[i][j]=get.get(columnsName[j]).toString();
            }
            
        }
//        
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

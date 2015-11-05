package br.com.cds.connecta.framework.connector.database;

import br.com.cds.connecta.framework.connector.util.ConnectorColumn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.metamodel.DataContext;

import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.CompiledQuery;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.SelectItem;

/**
 *
 * @author diego
 */
public class Database {

    public DataContext getDados(String drive, String server, String port, String sid, String user, String password) {

        System.out.println("driver: " + drive
                + "  server: " + server
                + "  port: " + port
                + "  sid: " + sid
                + "  user: " + user
                + "  password: " + password);

        DataContext dataContext = null;
        try {
            dataContext = DataContextFactory
                    .createJdbcDataContext(getConnection(drive, server, port, sid, user, password));
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return getResult(dataContext, columns);
        return dataContext;
    }

    public Connection getConnection(String drive, String server, String port, String sid, String user, String password) throws SQLException {
        Connection conn = null;
        if (drive.equals("ORACLE_SID")) {

            try {
                //oracle.jdbc.xa.client.OracleXADataSource
                //Class.forName("oracle.jdbc.driver.OracleDriver");
                Class.forName("oracle.jdbc.xa.client.OracleXADataSource");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }

            String teste = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;

            System.out.println(teste);

            conn = DriverManager.getConnection(teste, user, password);

        }
        return conn;

    }

    public List<Map<String, Object>> getResult(DataContext dataContext, List<ConnectorColumn> columns) {

        Query q = new Query();
        for (ConnectorColumn column : columns) {
            q.select(column.getFormula());
        }

        String[] table = columns.get(0).getFormula().split("\\.");
        q.from(table[0]);

        DataSet dataset = dataContext.executeQuery(q);

        List<Map<String, Object>> result = new ArrayList<>();
        for (Row row : dataset) {
            Object[] values = row.getValues();
            Map<String, Object> object = new HashMap<>(columns.size());
            for (int i = 0; i < values.length; i++) {
                Object value = values[i];
                object.put(columns.get(i).getLabel(), value);
            }
            result.add(object);

        }
        dataset.close();
        return result;

    }

    public List<Map<String, Object>> getResultSql(DataContext dataContext, List<ConnectorColumn> columns, String sql) {

        Query parseQuery = dataContext.parseQuery(sql);

        DataSet dataset = dataContext.executeQuery(parseQuery);
        CompiledQuery compileQuery = dataContext.compileQuery(parseQuery);

        List<Map<String, Object>> result = new ArrayList<>();

        for (Row row : dataset) {
            Object[] values = row.getValues();

            SelectItem[] selectItems = row.getSelectItems();

            Map<String, Object> object = new HashMap<>(selectItems.length);

            for (int i = 0; i < selectItems.length; i++) {

                for (ConnectorColumn column : columns) {
                    if (column.getName().equals(selectItems[i].getColumn().getName())) {
                        Object value = values[i];
                        object.put(column.getLabel(), value);
                    }
                }

            }
            result.add(object);

        }
        dataset.close();
        return result;

    }

    public List<Map<String, Object>> getResultSql(DataContext dataContext, String sql) {

        Query q = new Query();

        Query parseQuery = dataContext.parseQuery(sql);

        DataSet dataset = dataContext.executeQuery(parseQuery);

        List<Map<String, Object>> result = new ArrayList<>();

        for (Row row : dataset) {
            Object[] values = row.getValues();

            SelectItem[] selectItems = row.getSelectItems();

            Map<String, Object> object = new HashMap<>(selectItems.length);

            for (int i = 0; i < selectItems.length; i++) {

                Object value = values[i];
                object.put(selectItems[i].toString().replace("\"", ""), value);
            }
            result.add(object);

        }
        dataset.close();
        return result;

    }
//     public List<Map<String, Object>> getResultSql(DataContext dataContext, String sql) {
//        
//        Query q = new Query();
//        
//        Query parseQuery = dataContext.parseQuery(sql);
//        
//        DataSet dataset = dataContext.executeQuery(parseQuery);
//
//        List<Map<String, Object>> result = new ArrayList<>();
//        for (Row row : dataset) {
//            Object[] values = row.getValues();
//            
//            //result.add(object);
//
//        }
//        dataset.close();
//        return result;
//        
//    }

}

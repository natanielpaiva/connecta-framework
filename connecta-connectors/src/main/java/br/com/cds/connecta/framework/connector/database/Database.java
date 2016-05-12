package br.com.cds.connecta.framework.connector.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.SelectItem;

import br.com.cds.connecta.framework.connector.util.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import org.apache.log4j.Logger;

/**
 *
 * @author diego
 */
public class Database {

    private Connection conn = null;
    private final Logger logger = Logger.getLogger(Database.class);

    public DataContext getDados(String drive, String server, String port, String sid, String user, String password) {
        logger.info(String.format("driver: %s server: %s  port: %s sid: %s user: %s password: %s", drive, server, port, sid, user, password));

        DataContext dataContext = null;

        try {
            conn = getConnection(drive, server, port, sid, user, password);
            dataContext = DataContextFactory.createJdbcDataContext(conn);
        } catch (Exception ex) {
            try {
                conn.close();
            } catch (SQLException sqle) {
                logger.error("Unable to close connection", sqle);
            }
            logger.error("Unable to create JDBC Data Context", ex);
        }
        return dataContext;
    }

    public Connection getConnection(String drive, String server, String port, String sid, String user, String password) throws SQLException {
        Connection conn = null;

        if ("ORACLE_SID".equals(drive)) {
            try {
                Class.forName("oracle.jdbc.xa.client.OracleXADataSource");
            } catch (ClassNotFoundException ex) {
                logger.error("Cannot find Datasource Driver", ex);
            }

            String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
            logger.info(url);

            conn = DriverManager.getConnection(url, user, password);
        }
        if ("ORACLE_SNM".equals(drive)) {
            try {
                Class.forName("oracle.jdbc.xa.client.OracleXADataSource");
            } catch (ClassNotFoundException ex) {
                logger.error("Cannot find Datasource Driver", ex);
            }

            String url = "jdbc:oracle:thin:@//" + server + ":" + port + "/" + sid;
            logger.info(url);

            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }

    public List<Map<String, Object>> getResult(DataContext dataContext, List<ConnectorColumn> columns) {
        try {
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
        } catch (Exception e) {
            logger.error("Unable to get result", e);
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException sqle) {
                logger.error("Unable to close connection", sqle);
            }
        }
    }

    public List<Map<String, Object>> getResultSql(DataContext dataContext, List<ConnectorColumn> columns, String sql) {
        try {

            Query parseQuery = dataContext.parseQuery(sql);
            DataSet dataset = dataContext.executeQuery(parseQuery);

            List<Map<String, Object>> result = new ArrayList<>();

            for (Row row : dataset) {
                Object[] values = row.getValues();
                SelectItem[] selectItems = row.getSelectItems();

                Map<String, Object> object = new HashMap<>(selectItems.length);
                for (int i = 0; i < selectItems.length; i++) {
                    for (ConnectorColumn column : columns) {
                        if (selectItems[i].getAlias() != null) {
                            if (column.getName().equals(selectItems[i].getAlias())) {
                                Object value = values[i];
                                object.put(column.getLabel(), value);
                            }
                        } else {
                            if (column.getName().equals(selectItems[i].getColumn().getName())) {
                                Object value = values[i];
                                object.put(column.getLabel(), value);
                            }
                        }
                    }
                }
                result.add(object);
            }
            dataset.close();
            return result;
        } catch (Exception e) {
            logger.error("Unable to get result", e);
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException sqle) {
                logger.error("Unable to close connection", sqle);
            }
        }
    }

    public List<Map<String, Object>> getResultSql(DataContext dataContext, String sql) {
        try {
            Query parseQuery = dataContext.parseQuery(sql);
            DataSet dataset = dataContext.executeQuery(parseQuery);

            List<Map<String, Object>> result = new ArrayList<>();

            for (Row row : dataset) {
                Object[] values = row.getValues();
                SelectItem[] selectItems = row.getSelectItems();

                Map<String, Object> object = new HashMap<>(selectItems.length);
                for (int i = 0; i < selectItems.length; i++) {
                    Object value = values[i];
                    if (selectItems[i].getAlias() != null) {
                        object.put(selectItems[i].getAlias(), value);
                    } else {
                        object.put(selectItems[i].toString().replace("\"", ""), value);
                    }
                }
                result.add(object);
            }
            dataset.close();
            return result;
        } catch (Exception e) {
            logger.error("Unable to get result", e);
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException sqle) {
                logger.error("Unable to close connection", sqle);
            }
        }
    }

    public List<Map<String, Object>> getResultTable(DataContext dataContext, String table) {
        try {
            Query q = new Query();
            q.from(table);
            DataSet dataset = dataContext.executeQuery(q);

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
        } catch (Exception e) {
            logger.error("Unable to get result", e);
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException sqle) {
                logger.error("Unable to close connection", sqle);
            }
        }
    }

    public static void main(String args[]) {
        Database database = new Database();
        //dbc:oracle:thin:@192.168.1.185:1521:cdsdev
        DataContext dados = database.getDados("ORACLE_SID", "192.168.1.185", "1521", "cdsdev", "presenter2", "cds312");

        List<Map<String, Object>> resultSql = database.getResultSql(dados, "select * from TB_ANALYSIS");

        PrintResult.printMap(resultSql);
    }

}

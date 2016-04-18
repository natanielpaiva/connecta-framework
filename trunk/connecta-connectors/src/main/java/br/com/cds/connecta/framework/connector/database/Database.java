
package br.com.cds.connecta.framework.connector.database;

import br.com.cds.connecta.framework.connector.util.ConnectorColumn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.metamodel.DataContext;

import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.Query;
/**
 *
 * @author diego
 */
public class Database {
    
   
    
    public List<Map<String, Object>>  getDados(String drive, String server, String port, String sid, String user, String password, List<ConnectorColumn> columns){
        
        System.out.println( "driver: " + drive + 
                            "  server: " + server + 
                            "  port: "+ port + 
                            "  sid: " +   sid + 
                            "  user: " + user+ 
                            "  password: "+ password );
        
        List<Map<String, Object>> dataProvider = null;
         DataContext dataContext = null;
        try {
            dataContext = DataContextFactory
                    .createJdbcDataContext(getConnection( drive, server, port, sid, user, password));
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
           return dataProvider = getResult(dataContext, columns);
    }
    
     public Connection getConnection( String drive, String server, String port, String sid, String user, String password) throws SQLException {
        Connection conn = null;
        if (drive.equals("ORACLE_SID")) {
           
            try {
                //oracle.jdbc.xa.client.OracleXADataSource
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }

            String teste = "jdbc:oracle:thin:@"
                    + server
                    + ":"
                    + port
                    + ":"
                    + sid;

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
                object.put(columns.get(i).getLabel() , value);
            }
            result.add(object);

        }
        dataset.close();
        return result;
        
    }
    
}

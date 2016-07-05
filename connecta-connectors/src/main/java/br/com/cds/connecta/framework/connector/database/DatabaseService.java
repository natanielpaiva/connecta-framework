/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.cds.connecta.framework.connector.database.service.DatabaseTable;

/**
 *
 * @author diego
 */
public class DatabaseService {

    public List getTables(String server, String schema, String user, String password) 
    		throws SQLException{

        DatabaseTable databaseTable = new DatabaseTable();
        return databaseTable.getTables(server, schema, user, password);

    }
    
    public Connection testConnection(String server, String user, String password) 
    		throws SQLException{
    	
    	return DriverManager.getConnection(server, user, password);
    }
    
   
}

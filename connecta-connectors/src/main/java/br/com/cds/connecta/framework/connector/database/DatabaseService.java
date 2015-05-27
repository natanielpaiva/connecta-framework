/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector.database;

import br.com.cds.connecta.framework.connector.database.service.DatabaseTable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class DatabaseService {

    public List getTables(String server, String schema, String user, String password) {

        DatabaseTable databaseTable = new DatabaseTable();
        try {
            return databaseTable.getTables(server, schema, user, password);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
   
}

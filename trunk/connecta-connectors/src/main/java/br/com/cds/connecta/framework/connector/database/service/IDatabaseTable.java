/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector.database.service;

import java.util.List;

/**
 *
 * @author diego
 */
public interface IDatabaseTable {
    
    String getTableName();

    String getSchema();

    String getTableType();

    List<IDatabaseColumn> getColumns();
    
}

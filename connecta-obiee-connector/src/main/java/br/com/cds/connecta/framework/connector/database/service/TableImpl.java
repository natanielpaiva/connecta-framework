/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector.database.service;

import java.util.ArrayList;
import java.util.List;

class TableImpl implements IDatabaseTable {

    private static final long serialVersionUID = 1L;

    public TableImpl() {

    }

    public TableImpl(String tableName) {
        this.tableName = tableName;
    }

    private String tableName;
    private String schema;
    private String tableType;

    private List<IDatabaseColumn> columns;

    @Override
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public List<IDatabaseColumn> getColumns() {

        if (columns == null) {
            columns = new ArrayList<IDatabaseColumn>();
        }

        return columns;
    }

    @Override
    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

}

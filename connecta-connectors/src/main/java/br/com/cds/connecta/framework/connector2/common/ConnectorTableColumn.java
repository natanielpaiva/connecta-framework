package br.com.cds.connecta.framework.connector2.common;

import java.util.List;

/**
 *
 * @author diego
 */
public class ConnectorTableColumn {
    
    private String tableName;
    
    private List<ConnectorColumn> ConnectorColumn;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ConnectorColumn> getConnectorColumn() {
        return ConnectorColumn;
    }

    public void setConnectorColumn(List<ConnectorColumn> ConnectorColumn) {
        this.ConnectorColumn = ConnectorColumn;
    }

    
}

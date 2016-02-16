package br.com.cds.connecta.framework.connector2.context.file;

import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.FileContextFactory;
import java.util.ArrayList;
import java.util.List;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;

/**
 *
 * @author diego
 */
public class FileDataContextFactory extends Base implements ContextFactory {

    public FileDataContextFactory(FileContextFactory fileContextFactory) {
        dataContext = fileContextFactory.createDataContext();
    }

    @Override
    public DataSet getResultAll() {

        Table table = getTable();

        String[] columnNames = table.getColumnNames();
        for (String columnName : columnNames) {
            System.out.println(columnName);
        }

        queryContext.getQuery().from(table);

        String[] requiredColumns = queryContext.getColumns();

        if (requiredColumns != null) {
            for (String requiredColumn : requiredColumns) {

                Column columnByName = table.getColumnByName(requiredColumn);

                try {
                    queryContext.getQuery().select(columnByName);
                } catch (java.lang.IllegalArgumentException e) {
                    System.out.println("Columa nao encontrada: " + columnByName);
                }

            }
        } else {
            queryContext.getQuery().selectAll();
        }

        DataSet executeQuery = dataContext.executeQuery(queryContext.getQuery());

        return executeQuery;
    }

    @Override
    public List<ConnectorColumn> getColumns() {
        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        Table table = dataContext.getDefaultSchema().getTable(0);
        Column[] columns = table.getColumns();

        for (Column column : columns) {
            ConnectorColumn cc = new ConnectorColumn();
            cc.setName(column.getName());
            cc.setType(column.getType().getName());
            cc.setFormula(column.getName());
            cc.setLabel(column.getName());

            connectorColumns.add(cc);
        }
        return connectorColumns;
    }

    @Override
    public Table getTable() {
        return dataContext.getDefaultSchema().getTable(0);
    }

    public Column getColumn(String columnName) {
        return getTable().getColumnByName(columnName);
    }

}

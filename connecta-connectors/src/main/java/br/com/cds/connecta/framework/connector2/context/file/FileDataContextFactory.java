package br.com.cds.connecta.framework.connector2.context.file;

import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.FileContextFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.MetaModelException;
import org.apache.metamodel.convert.Converters;
import org.apache.metamodel.convert.TypeConverter;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.pojo.ArrayTableDataProvider;
import org.apache.metamodel.pojo.PojoDataContext;
import org.apache.metamodel.pojo.TableDataProvider;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.ColumnType;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.SimpleTableDef;

/**
 *
 * @author diego
 */
public class FileDataContextFactory extends Base implements ContextFactory {

    private final Logger logger = Logger.getLogger(FileDataContextFactory.class);

    public FileDataContextFactory(FileContextFactory fileContextFactory) {

        dataContext = converterDataContextToPojoDataContext(fileContextFactory.createDataContext());
    }

    @Override
    public DataSet getResultAll() {

        Table table = getTable();
        table.getColumns(); // chamada pra reconhecer as colunas

        List<ConnectorColumn> listColumns = queryContext.getColumns();

        Query from = queryContext.build().from(table);

        if (listColumns != null && from.getSelectClause().getItems().isEmpty()) {
            for (ConnectorColumn column : listColumns) {
                Column columnByName = table.getColumnByName(column.getName());
                queryContext.build().select(columnByName);
            }
            return dataContext.executeQuery(from);
        } else if (!from.getSelectClause().getItems().isEmpty()) {
            return dataContext.executeQuery(from);
        } else {
            return dataContext.executeQuery(from.selectAll());
        }

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

    @Override
    public String[] getSchemas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getTables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataContext createDataContext() {
        return dataContext;
    }

    public final DataContext converterDataContextToPojoDataContext(DataContext dc) {

        DataSet execute = getDataSet(dc);

        ColumnType[] columnsTypes = createColumnsDefalt(dc);

        Map<Column, TypeConverter<?, ?>> map = discoverPossibleConverters(dc);

        for (Map.Entry<Column, TypeConverter<?, ?>> entrySet : map.entrySet()) {
            Column key = entrySet.getKey();

            TypeConverter<? extends Object, ? extends Object> value = entrySet.getValue();

            if (value.getClass().toString().contains("Boolean")) {
                columnsTypes[key.getColumnNumber()] = ColumnType.BOOLEAN;
            } else if (value.getClass().toString().contains("Integer")) {
                columnsTypes[key.getColumnNumber()] = ColumnType.INTEGER;
            } else if (value.getClass().toString().contains("Date")) {
                columnsTypes[key.getColumnNumber()] = ColumnType.DATE;
            } else if (value.getClass().toString().contains("Double")) {
                columnsTypes[key.getColumnNumber()] = ColumnType.DOUBLE;
            }
        }

        String[] columnNames = dc.getDefaultSchema().getTables()[0].getColumnNames();
        SimpleTableDef std = new SimpleTableDef(dc.getDefaultSchema().getTables()[0].getName(), columnNames, columnsTypes);
        //SimpleTableDef std = new SimpleTableDef("file", columnNames, columnsTypes);
        List<Object[]> list = new ArrayList<>();

        for (Row ex : execute) {
            Object[] obj = new Object[columnNames.length];
            for (int i = 0; i < columnNames.length; i++) {

                if (columnsTypes[i].equals(ColumnType.INTEGER)) {
                    if (ex.getValues()[i].toString().equals("")) {
                        obj[i] = Integer.valueOf("0");
                    } else {
                        obj[i] = Integer.valueOf(ex.getValues()[i].toString());
                    }
                } else if (columnsTypes[i].equals(ColumnType.BOOLEAN)) {
                    obj[i] = ex.getValues()[i].toString();
                } else if (columnsTypes[i].equals(ColumnType.DATE)) {
                    obj[i] = String.valueOf(ex.getValues()[i].toString());
                } else if (columnsTypes[i].equals(ColumnType.DOUBLE)) {
                    if (ex.getValues()[i].toString().equals("")) {
                        obj[i] = Double.valueOf("0");
                    } else {
                        obj[i] = Double.valueOf(ex.getValues()[i].toString());
                    }
                } else {
                    obj[i] = ex.getValues()[i];
                }
            }
            list.add(obj);
        }

        TableDataProvider<?> tableDataProvider = new ArrayTableDataProvider(std, list);
        dataContext = new PojoDataContext(dc.getDefaultSchema().getName(), tableDataProvider);
        return dataContext;
    }

    private ColumnType[] createColumnsDefalt(DataContext dc) throws MetaModelException {
        ColumnType[] columnsTypes = new ColumnType[dc.getDefaultSchema().getTables()[0].getColumnCount()];
        for (int i = 0; i < columnsTypes.length; i++) {
            columnsTypes[i] = ColumnType.STRING;
        }
        return columnsTypes;
    }

    private Map<Column, TypeConverter<?, ?>> discoverPossibleConverters(DataContext dc) {
        Map<Column, TypeConverter<?, ?>> map = Converters.autoDetectConverters(dc, dc.getDefaultSchema().getTables()[0].getColumns(), 100);
        return map;
    }

    private DataSet getDataSet(DataContext dc) {
        DataSet execute = dc.query().from(dc.getDefaultSchema().getTable(0)).selectAll().execute();
        return execute;
    }

}

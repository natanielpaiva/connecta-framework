package br.com.cds.connecta.framework.connector2.context.composite;

import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.CompositeJoin;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import java.util.ArrayList;
import java.util.List;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.pojo.ArrayTableDataProvider;
import org.apache.metamodel.pojo.PojoDataContext;
import org.apache.metamodel.pojo.TableDataProvider;
import org.apache.metamodel.query.FromItem;
import org.apache.metamodel.query.JoinType;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.SelectItem;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.MutableColumn;
import org.apache.metamodel.schema.MutableTable;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.SimpleTableDef;

/**
 *
 * @author diego
 */
public class CompositeDataContextFactory extends Base implements ContextFactory {

    List<ConnectorColumn> connectorColumns = new ArrayList<>();

//      List<CompositeJoin> listCompositeJoin;   
//    public CompositeDataContextFactory(List<CompositeJoin> listCompositeJoin ) {
//        this.listCompositeJoin = listCompositeJoin;
//        
//        DataContext dataContextCurrent = null;
//    }
    public CompositeDataContextFactory(
            ContextFactory leftContext,
            String leftColumn,
            String leftAlias,
            JoinType joinType,
            ContextFactory rightContext,
            String rightColumn,
            String rightAlias) {

        FromItem fromItem = new FromItem(joinType,
                new FromItem(leftContext.getTable()).setAlias(leftAlias),
                new FromItem(rightContext.getTable()).setAlias(rightAlias),
                new SelectItem[]{new SelectItem(leftContext.getColumn(leftColumn))},
                new SelectItem[]{new SelectItem(rightContext.getColumn(rightColumn))});

        Query query = new Query();
        query.from(fromItem);

        DataContext composite = DataContextFactory.createCompositeDataContext(leftContext.getDataContext(), rightContext.getDataContext());
        DataSet dataset = composite.executeQuery(query.selectAll());

        List<Object[]> toObjectArrays = dataset.toObjectArrays();

        MutableTable mutableTable = new MutableTable("composite");
        SelectItem[] selectItems = dataset.getSelectItems();
        for (SelectItem selectItem : selectItems) {
            MutableColumn mutableColumn = new MutableColumn();
            mutableColumn.setTable(mutableTable);
            mutableColumn.setName(selectItem.getSameQueryAlias());
            mutableColumn.setType(selectItem.getColumn().getType());

            mutableTable.addColumn(mutableColumn);

            ConnectorColumn cc = new ConnectorColumn();
            cc.setLabel(selectItem.getSameQueryAlias());
            cc.setName(selectItem.getSameQueryAlias());
            cc.setFormula(null);
            cc.setType(selectItem.getColumn().getType().getName());
            connectorColumns.add(cc);
        }

        SimpleTableDef std = new SimpleTableDef(mutableTable);
        TableDataProvider<?> tableDataProvider = new ArrayTableDataProvider(std, toObjectArrays);

        dataContext = new PojoDataContext("pojo", tableDataProvider);

    }

    @Override
    public DataSet getResultAll() {
        Schema schema = discoverSchema();

        Table discoveredTable = discoverTable(schema);
        discoveredTable.getColumns(); // chamada pra reconhecer as colunas

        List<ConnectorColumn> listColumns = queryContext.getColumns();

        Query from = queryContext.build().from(discoveredTable);

        if (listColumns != null
                && queryContext.build().getSelectClause().getItems().isEmpty()) {
            for (ConnectorColumn column : listColumns) {
                Column columnByName = getColumn(column.getFormula());
                if (columnByName != null) {
                    queryContext.build().select(columnByName);
                }
            }
            return dataContext.executeQuery(queryContext.build());
        } else if (!from.getSelectClause().getItems().isEmpty()) {
            return dataContext.executeQuery(from);
        } else {
            return dataContext.executeQuery(from.selectAll());
        }
    }

    private Schema discoverSchema() {
        return dataContext.getDefaultSchema();
    }

    private Table discoverTable(Schema schema) {
        return schema.getTableByName("composite");
    }

    @Override
    public List<ConnectorColumn> getColumns() {
        return connectorColumns;
    }

    @Override
    public Table getTable() {
        return dataContext.getDefaultSchema().getTable(0);
    }

    @Override
    public Column getColumn(String columnName) {

        Column column = null;
        for (Schema schema : dataContext.getSchemas()) {
            if (schema.getTables()[0].getColumnByName(columnName) != null) {
                column = schema.getTables()[0].getColumnByName(columnName);
            }
        }
        return column;

    }

    @Override
    public String[] getSchemas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getTables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

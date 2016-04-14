package br.com.cds.connecta.framework.connector2.context.file;

import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.FileContextFactory;
import java.util.ArrayList;
import java.util.List;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.query.FunctionType;
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

        //String[] requiredColumns = queryContext.getColumns();
        String[] requiredColumns = null;

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
            queryContext.getQuery();
        }

        DataSet executeQuery = dataContext.executeQuery(queryContext.getQuery());

        
//funcioando
//DataSet executeQuery = dataContext.executeQuery(queryContext.getQuery().select(" AVG(csvdata.csv.funcionario)" ).groupBy("nome"));        
//SELECT csvdata.csv.funcionario, csvdata.csv.nome, csvdata.csv.departamento, csvdata.csv.email, AVG(csvdata.csv.funcionario) FROM testdata.csvdata.csv GROUP BY csvdata.csv.nome
//SELECT csvdata.csv.nome, AVG(csvdata.csv.funcionario), csvdata.csv.funcionario, csvdata.csv.nome, csvdata.csv.departamento, csvdata.csv.email FROM testdata.csvdata.csv GROUP BY csvdata.csv.nome


//SELECT AVG(csvdata.csv.funcionario), csvdata.csv.funcionario, csvdata.csv.nome, csvdata.csv.departamento, csvdata.csv.email FROM testdata.csvdata.csv GROUP BY csvdata.csv.nome

        
// DataSet executeQuery = dataContext.executeQuery(queryContext.getQuery()
//                    .select(FunctionType.AVG, getColumn("funcionario"))
//                    .select(getColumn("nome"))
//                    .groupBy("nome"));
//SELECT csvdata.csv.funcionario, csvdata.csv.nome, csvdata.csv.departamento, csvdata.csv.email, AVG(csvdata.csv.funcionario), csvdata.csv.nome                     FROM testdata.csvdata.csv GROUP BY csvdata.csv.nome
        
//SELECT AVG(csvdata.csv.funcionario), csvdata.csv.nome, csvdata.csv.nome, csvdata.csv.funcionario, csvdata.csv.nome, csvdata.csv.departamento, csvdata.csv.email FROM testdata.csvdata.csv GROUP BY csvdata.csv.nome

//SELECT COUNT(csvdata.csv.funcionario), csvdata.csv.nome, csvdata.csv.nome, csvdata.csv.funcionario, csvdata.csv.nome, csvdata.csv.departamento, csvdata.csv.email FROM testdata.csvdata.csv GROUP BY csvdata.csv.nome

 
System.out.println("-dddddddddddddddddd----------" + queryContext.getQuery().toString());
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

    @Override
    public String[] getSchemas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getTables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package br.com.cds.connecta.framework.connector2.test;

import br.com.cds.connecta.framework.connector2.FusionClient;
import br.com.cds.connecta.framework.connector2.Request;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.common.QueryContext;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.mysql.MySqlConnection;
import br.com.cds.connecta.framework.connector2.context.database.oracle.OracleConnection;
import java.util.List;
import java.util.Map;
import org.apache.metamodel.query.OperatorType;


/**
 *
 * @author diego
 */
public class DatabaseTest {

    public static void main(String args[]) {
        
        FusionClient fusionClient = new FusionClient();
        PrintResult printResult = new PrintResult();
        
        
        DatabaseDataContextFactory mySqldatabase = new DatabaseDataContextFactory(
                new MySqlConnection("192.168.33.10", "3306", "memorando" ),"tb_usuario" ,"root", "root");
        
        //mySqldatabase.createDataContext();
       // String[] columnNames = {"nome", "email"};
        QueryContext query = new QueryContext();
        query.setColumns(new String[]{"nome", "senha"}).getQuery().where(mySqldatabase.getColumn("nome"), OperatorType.EQUALS_TO, "Pâmela Leal");
       // query.setPagination(1, 10).setColumns(new String[]{"nome", "senha"});
        //query.setTable("Conta").setPagination(1, 5).setSchema("financas");
        
        Request dataBaseMySqlRequest = new Request(mySqldatabase,query);
        List<Map<String, Object>> all1 = fusionClient.getAll(dataBaseMySqlRequest);
        
        
        printResult.printMap2(all1);
//        
//        List<ConnectorColumn> mysqlColumns = fusionClient.getColumns(dataBaseMySqlRequest);
//        printResult.printColumns(mysqlColumns);
//        
//        
//        
//        mySqldatabase.createDataContext();
//        
//        String[] schema = mySqldatabase.getSchemas();
//        printResult.printArrayString(schema);
//        
//        String[] table = mySqldatabase.getTables();
//        printResult.printArrayString(table);
        
//        
        
        
        
        DatabaseDataContextFactory Oracledatabase = new DatabaseDataContextFactory(
                new OracleConnection("192.168.1.185", "1521", "cdsdev"),
                //new OracleConnection("192.168.1.185", "1521"),
                "presenter2", "cds312");
        
        Oracledatabase.createDataContext();
        String[] schema1 = Oracledatabase.getSchemas();
        printResult.printArrayString(schema1);
        
        QueryContext oracleQuery = new QueryContext();
        oracleQuery.setSchema("PRESENTER2")
                    .setTable("TB_ANALYSIS")
                    .setPagination(1, 3)
                    .setColumns(new String[]{"DS_ANALYSIS", "TP_ANALYSIS"});
        
        
        Request DataBaseOracleRequest = new Request(Oracledatabase, oracleQuery);
        List<Map<String, Object>> all = fusionClient.getAll(DataBaseOracleRequest);
        printResult.printMap2(all);
        
        List<ConnectorColumn> columns = fusionClient.getColumns(DataBaseOracleRequest);
        
        printResult.printColumns(columns);
        
        Oracledatabase.createDataContext();
        printResult.printArrayString(Oracledatabase.getSchemas());
        printResult.printArrayString(Oracledatabase.getTables());
        
    }

}

package br.com.cds.connecta.framework.connector2.test;

import br.com.cds.connecta.framework.connector2.FusionClient;
import br.com.cds.connecta.framework.connector2.Request;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.common.QueryContext;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.Driver;
import br.com.cds.connecta.framework.connector2.context.database.mysql.MySqlConnection;
import br.com.cds.connecta.framework.connector2.context.database.oracle.OracleConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diego
 */
public class DatabaseTest {

    public static void main(String args[]) {
        FusionClient fusionClient = new FusionClient();
        PrintResult printResult = new PrintResult();

//        testMysqlManualQuery(fusionClient, printResult);
        testOracleTableQuery(fusionClient, printResult);
      // testOracleManualQuery(fusionClient, printResult);
    }

    public static void testOracleTableQuery(FusionClient fusionClient, PrintResult printResult) {
        DatabaseDataContextFactory dataContextFactory = new DatabaseDataContextFactory(
                new OracleConnection("192.168.1.185", "1521", "cdsdev"),
                "presenter2", "cds312");

        //dataContextFactory.createDataContext();
        String[] schema1 = dataContextFactory.getSchemas();
        printResult.printArrayString(schema1);
        
      
        List<ConnectorColumn> columnsColumn = new ArrayList<>();
        ConnectorColumn connectorColumn1 = new ConnectorColumn();

        connectorColumn1.setId((long) 14452);
        connectorColumn1.setName("DS_ANALYSIS");
        connectorColumn1.setLabel("DS_ANALYSIS");
        connectorColumn1.setFormula("DS_ANALYSIS");
        
        
        ConnectorColumn connectorColumn2 = new ConnectorColumn();

        connectorColumn2.setId((long) 14452);
        connectorColumn2.setName("TP_ANALYSIS");
        connectorColumn2.setLabel("TP_ANALYSIS");
        connectorColumn2.setFormula("TP_ANALYSIS");
        

        columnsColumn.add(connectorColumn1);
        columnsColumn.add(connectorColumn2);
        
        
        QueryContext oracleQuery = new QueryContext();
        oracleQuery.setSchema("PRESENTER2")
                .setTable("TB_ANALYSIS")
                .setPagination(1, 10)
                .setConnectorColumns(columnsColumn);
                //.setColumns(new String[]{"DS_ANALYSIS", "TP_ANALYSIS"});
                //.setColumns(columnsColumn);

        Request DataBaseOracleRequest = new Request(dataContextFactory, oracleQuery);
        List<Map<String, Object>> all = fusionClient.getAll(DataBaseOracleRequest);
        printResult.printMap2(all);

        //List<ConnectorColumn> columns = fusionClient.getColumns(DataBaseOracleRequest);

        //printResult.printColumns(columns);

        //dataContextFactory.createDataContext();
        //printResult.printArrayString(dataContextFactory.getSchemas());
        //printResult.printArrayString(dataContextFactory.getTables());
    }

    public static void testMysqlManualQuery(FusionClient fusionClient, PrintResult printResult) {
        //        DatabaseDataContextFactory mySqldatabase = new DatabaseDataContextFactory(
//                new MySqlConnection("192.168.33.10", "3306", "memorando" ),"tb_usuario" ,"root", "root");
        DatabaseDataContextFactory mySqldatabase = new DatabaseDataContextFactory(
                "				SELECT m.id_memorando				  AS cod     ,\n"
                + "			   m.id_memorando_can    				  AS cod2    ,\n"
                + "			   date_format(m.dt_timestamp,'%d/%m/%y') AS Data    ,\n"
                + "			   m.assunto                              AS Assunto ,\n"
                + "			   p.nome                                 AS Projeto ,\n"
                + "			   tm.desc_tipo_memorando                 AS Tipo ,\n"
                + "   			   m.cod_tmp                              AS CodTMP ,\n"
                + "			   CASE\n"
                + "					  WHEN id_memorando_can IS NULL\n"
                + "					  THEN '---'\n"
                + "					  ELSE '<img src=\\\"images/checkVerde.gif\\\" alt=\\\"Visualizar memorando Retificado\\\" style=\\\"cursor:pointer\\\" onclick=\\\"visualizarMemorando(\\'|XX|\\')\\\">'\n"
                + "			   END AS R ,\n"
                + "			   CASE\n"
                + "					  WHEN\n"
                + "							 (SELECT COUNT(*)\n"
                + "									 FROM    tb_passagem\n"
                + "									 WHERE   id_memorando = m.id_memorando\n"
                + "									 AND     ativo  IS NULL\n"
                + "							 )\n"
                + "							 = 0\n"
                + "					  THEN '<img src=\\\"images/aviao.jpg\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Transporte\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addTransporte(\\'|X|\\')\\\">'\n"
                + "					  ELSE '<img src=\\\"images/aviaoV.jpg\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Transporte\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addTransporte(\\'|X|\\')\\\">'\n"
                + "			   END AS 'Tr.' ,\n"
                + "			   CASE\n"
                + "					  WHEN\n"
                + "							 (SELECT COUNT(*)\n"
                + "									 FROM    tb_hospedagem\n"
                + "									 WHERE   id_memorando = m.id_memorando\n"
                + "									 AND     ativo  IS NULL\n"
                + "							 )\n"
                + "							 = 0\n"
                + "					  THEN '<img src=\\\"images/hotel.gif\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Hotel\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addHospedagem(\\'|X|\\')\\\">'\n"
                + "					  ELSE '<img src=\\\"images/hotelV.gif\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Hotel\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addHospedagem(\\'|X|\\')\\\">'\n"
                + "			   END AS 'Hl.' ,\n"
                + "			   CASE\n"
                + "					  WHEN\n"
                + "							 (SELECT COUNT(*)\n"
                + "									 FROM    tb_locacao\n"
                + "									 WHERE   id_memorando = m.id_memorando\n"
                + "									 AND     ativo  IS NULL\n"
                + "							 )\n"
                + "							 = 0\n"
                + "					  THEN '<img src=\\\"images/carro.gif\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Locação\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addLocadora(\\'|X|\\')\\\">'\n"
                + "					  ELSE '<img src=\\\"images/carroV.gif\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Locação\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addLocadora(\\'|X|\\')\\\">'\n"
                + "			   END AS 'Lo.' ,\n"
                + "			   CASE\n"
                + "					  WHEN\n"
                + "							 (SELECT COUNT(*)\n"
                + "									 FROM    tb_atividade\n"
                + "									 WHERE   id_memorando = m.id_memorando\n"
                + "									 AND     ativo  IS NULL\n"
                + "							 )\n"
                + "							 = 0\n"
                + "					  THEN '<img src=\\\"images/atividade.jpg\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Atividade\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addAtividade(\\'|X|\\')\\\">'\n"
                + "					  ELSE '<img src=\\\"images/atividadeV.jpg\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Atividade\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addAtividade(\\'|X|\\')\\\">'\n"
                + "			   END AS 'At.',\n"
                + "\n"
                + "\n"
                + "			   CASE\n"
                + "					  WHEN\n"
                + "							 (SELECT COUNT(*)\n"
                + "									 FROM    tb_atividade\n"
                + "									 WHERE   id_memorando = m.id_memorando\n"
                + "									 AND     ativo  IS NULL\n"
                + "							 )\n"
                + "							 = 0\n"
                + "					  THEN '<img src=\\\"images/taxi.png\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Atividade\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addSimulacaoTaxi(\\'|X|\\')\\\">'\n"
                + "					  ELSE '<img src=\\\"images/taxiV.png\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Atividade\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addSimulacaoTaxi(\\'|X|\\')\\\">'\n"
                + "			   END AS 'Tx.',\n"
                + "\n"
                + "\n"
                + "			   CASE\n"
                + "					  WHEN\n"
                + "							 (SELECT COUNT(*)\n"
                + "									 FROM    tb_observacao\n"
                + "									 WHERE   id_memorando = m.id_memorando\n"
                + "									 AND     ativo  IS NULL\n"
                + "							 )\n"
                + "							 = 0\n"
                + "					  THEN '<img src=\\\"images/obs.gif\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Observações\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addObs(\\'|X|\\')\\\">'\n"
                + "					  ELSE '<img src=\\\"images/obsA.gif\\\" width=\\\"18px\\\" height=\\\"18px\\\" alt=\\\"Observações\\\" style=\\\"cursor:pointer\\\" onclick=\\\"addObs(\\'|X|\\')\\\">'\n"
                + "			   END AS 'Ob.',\n"
                + "			    CASE\n"
                + "					  WHEN m.motivo_n_aprovado is null\n"
                + "					  THEN ''\n"
                + "					  ELSE concat('<img src=\\\"images/exclamacao.gif\\\" onMouseOver=\\\"return escape(\\'',replace(m.motivo_n_aprovado,'\\\\n','<br>'),'\\')\\\" width=\\\"10px\\\" height=\\\"10px\\\" alt=\\\"motivo reprovação\\\" style=\\\"cursor:pointer\\\" >')\n"
                + "			   END AS 'Rp.'\n"
                + "		FROM   tb_memorando m\n"
                + "			   INNER JOIN tb_projeto p\n"
                + "			   ON     m.id_projeto = p.id_projeto\n"
                + "			   LEFT JOIN tb_tipo_memorando tm\n"
                + "			   ON     m.id_tipo_memorando = tm.id_tipo_memorando\n"
                + "		WHERE  m.ativo       IS NULL\n"
                + "		AND    m.status      IS NULL\n"
                + "		ORDER BY\n"
                + "			Projeto	,\n"
                + "			Data",
                new MySqlConnection("192.168.33.10", "3306", "memorando"),
                "root", "root");
        QueryContext query = new QueryContext();
        //query.setColumns(new String[]{"Data", "Assunto"}).getQuery().where(mySqldatabase.getColumn("nome"), OperatorType.EQUALS_TO, "Pâmela Leal");
        //query.setColumns(new String[]{"Data", "Assunto"});
        query.setPagination(1, 20);
        Request dataBaseMySqlRequest = new Request(mySqldatabase, query);
        List<Map<String, Object>> all1 = fusionClient.getAll(dataBaseMySqlRequest);
        printResult.printMap2(all1);
//        
        List<ConnectorColumn> mysqlColumns = fusionClient.getColumns(dataBaseMySqlRequest);
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
    }

    private static void testOracleManualQuery(FusionClient fusionClient, PrintResult printResult) {
        String sql = "SELECT COUNT(TP_DATASOURCE), TP_DATASOURCE FROM TB_DATASOURCE GROUP BY TP_DATASOURCE";
        Driver driver = new OracleConnection("192.168.1.185", "1521", "cdsdev");
        
        DatabaseDataContextFactory dataContextFactory = new DatabaseDataContextFactory(sql, driver,
                "PRESENTER2", "cds312");
        
        
        
          List<ConnectorColumn> columnsColumn = new ArrayList<>();
        ConnectorColumn connectorColumn1 = new ConnectorColumn();

        connectorColumn1.setId((long) 14452);
        connectorColumn1.setName("TP_DATASOURCE");
        connectorColumn1.setLabel("TP_DATASOURCEssss");
        connectorColumn1.setFormula("TP_DATASOURCE");
        
        ConnectorColumn connectorColumn2 = new ConnectorColumn();

        connectorColumn2.setId((long) 14452);
        connectorColumn2.setName("COUNT(TP_DATASOURCE)");
        connectorColumn2.setLabel("COUNT");
        connectorColumn2.setFormula("COUNT(TP_DATASOURCE)");

        columnsColumn.add(connectorColumn1);
        columnsColumn.add(connectorColumn2);
        QueryContext query = new QueryContext()
                .setConnectorColumns(columnsColumn);
        
        Request request = new Request(dataContextFactory, query);
        List<Map<String, Object>> all = fusionClient.getAll(request);
        printResult.printMap2(all);
    }

}

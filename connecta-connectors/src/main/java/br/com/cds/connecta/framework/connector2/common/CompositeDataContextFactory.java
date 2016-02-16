package br.com.cds.connecta.framework.connector2.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.query.OperatorType;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.builder.SatisfiedSelectBuilder;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;

/**
 *
 * @author diego
 */
public class CompositeDataContextFactory implements ContextFactory {

    DataContext dataContext;

    QueryContext queryContext;

    ContextFactory leftContextFactory, rightContextFactory;

    SatisfiedSelectBuilder<?> selectAll;

    DataContext[] _delegates;
    Query from;

    List<CompositeJoin> compositeJoins;

    public CompositeDataContextFactory(List<CompositeJoin> compositeJoins) {
        this.compositeJoins = compositeJoins;

        Collection<DataContext> dc = new ArrayList();

        for (CompositeJoin compositeJoin : compositeJoins) {

            if (!dc.contains(compositeJoin.getLeftContextFactory().getDataContext())) {
                dc.add(compositeJoin.getLeftContextFactory().getDataContext());
            }

            if (!dc.contains(compositeJoin.getRightContextFactory().getDataContext())) {
                dc.add(compositeJoin.getRightContextFactory().getDataContext());
            }

        }

        this.dataContext = DataContextFactory.createCompositeDataContext(dc);

    }

    public void contructJoin() {

       Collection<Table> tb= new ArrayList() ;
        for (CompositeJoin cj : compositeJoins) {
           
            queryContext.getQuery()
                    
                    .where(cj.getLeftColumn(), 
                            OperatorType.EQUALS_TO,  
                            cj.getRightColumn()
                    );
            System.out.println("*************" + cj.getLeftColumn());
            System.out.println("*******" + OperatorType.EQUALS_TO);
             System.out.println("*************" + cj.getLeftColumn());        
            
          if(!tb.contains(cj.getLeftContextFactory().getTable())){
            tb.add(cj.getLeftContextFactory().getTable());
              
          }
          
          if(!tb.contains(cj.getRightContextFactory().getTable())){
            tb.add(cj.getRightContextFactory().getTable());
              
          }
        }
        
        for (Table tb1 : tb) {
            
            System.out.println("------------- " + tb1.getName());
            queryContext.getQuery().from(tb1);
        }

    }

//    public CompositeDataContextFactory(ContextFactory leftContextFactory, ContextFactory rightContextFactory) {
//        this.leftContextFactory = leftContextFactory;
//        this.rightContextFactory = rightContextFactory;
//
//        this.dataContext = DataContextFactory.createCompositeDataContext(new DataContext[]{
//            leftContextFactory.createDataContext(),
//            rightContextFactory.createDataContext()
//        });
//
//        selectAll = dataContext.query().from(leftContextFactory.getTable())
//                .innerJoin(rightContextFactory.getTable())
//                .on(rightContextFactory.getKey(), leftContextFactory.getKey()).selectAll();
//    }

    @Override
    public DataContext createDataContext() {
        return dataContext;
    }

    @Override
    public DataSet getResultAll() {
        contructJoin();

        DataSet executeQuery = dataContext.executeQuery(queryContext.getQuery().selectAll());

        return executeQuery;
    }

    @Override
    public List<ConnectorColumn> getColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setQueryContext(QueryContext queryContext) {
        this.queryContext = queryContext;
    }

    @Override
    public Table getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public CompositeDataContextFactory(DataContext leftDataContext, DataContext rightDataContext) {
//      
    //DataContext leftDC = leftDataContext.createDataContext();  
//        //DataContext rightDC = rightDataContextFactory.createDataContext();
//        
//        
//        DataContext compositeDataContext = DataContextFactory.createCompositeDataContext(new DataContext[]{
//            leftDataContext, rightDataContext
//        });
//          
//        //new FromItem[]{leftDataContext.getTable(), rightDataContextFactory.getTable()};
//        Table table1 = leftDataContext.getDefaultSchema().getTable(0);
//        Table table2 = rightDataContext.getDefaultSchema().getTable(0);
//         query.where(table1 , table2, JoinType.LEFT , table1.getColumnByName("departamento"), table2.getColumnByName("@id"));
////  
//        compositeDataContext.compileQuery(query.selectAll());
//        
////        query.where(leftDC.getColumnByQualifiedLabel("departamento"), OperatorType.EQUALS_TO, rightDC.getColumnByQualifiedLabel("@id"));
//        //query.from(, rightDC, JoinType.LEFT, leftDataContext.getTable(),  );
//    }
//    @Override
//    public ContextFactory setKey(String key) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public Column getKey() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public DataContext getDataContext() {
        return dataContext;
    }

    @Override
    public Column getColumn(String columnName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

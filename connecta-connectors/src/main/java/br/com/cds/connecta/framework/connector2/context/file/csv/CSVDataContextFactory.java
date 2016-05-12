package br.com.cds.connecta.framework.connector2.context.file.csv;

import br.com.cds.connecta.framework.connector2.common.FileContextFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.MetaModelException;
import org.apache.metamodel.convert.Converters;
import org.apache.metamodel.convert.TypeConverter;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.pojo.ArrayTableDataProvider;
import org.apache.metamodel.pojo.MapTableDataProvider;
import org.apache.metamodel.pojo.PojoDataContext;
import org.apache.metamodel.pojo.TableDataProvider;
import org.apache.metamodel.query.builder.SatisfiedSelectBuilder;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.ColumnType;
import org.apache.metamodel.util.FileHelper;
import org.apache.metamodel.util.SimpleTableDef;

/**
 *
 * @author diego
 */
public class CSVDataContextFactory implements FileContextFactory {

    private DataContext dataContext;

    private String csv;

    private File file;

    private char separatorChar = ',';

    private char quoteChar = '\"';

    public CSVDataContextFactory(String csv) {
        this.csv = csv;
        InputStream inputStream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));
        dataContext = DataContextFactory.createCsvDataContext(inputStream, separatorChar, quoteChar);

    }

    public CSVDataContextFactory(String csv, char separatorChar, char quoteChar) {
        this.csv = csv;

        if (separatorChar != ' ') {
            this.separatorChar = separatorChar;
        }

        if (quoteChar != ' ') {
            this.quoteChar = quoteChar;
        }

        InputStream inputStream = new ByteArrayInputStream(this.csv.getBytes(StandardCharsets.UTF_8));
        dataContext = DataContextFactory.createCsvDataContext(inputStream, this.separatorChar, this.quoteChar);
    }

    public CSVDataContextFactory(File file) {
        this.file = file;
        dataContext = DataContextFactory.createCsvDataContext(this.file, this.separatorChar, this.quoteChar, FileHelper.UTF_8_ENCODING);
    }

    public CSVDataContextFactory(File file, char separatorChar, char quoteChar) {
        this.file = file;

        if (separatorChar != ' ') {
            this.separatorChar = separatorChar;
        }

        if (quoteChar != ' ') {
            this.quoteChar = quoteChar;
        }
        dataContext = DataContextFactory.createCsvDataContext(this.file, this.separatorChar, this.quoteChar, FileHelper.UTF_8_ENCODING);

    }


    @Override
    public DataContext createDataContext() {
        return dataContext;
    }

    
//    public DataContext converterDataContextToPojoDataContext(DataContext dc) {
//        
//        DataSet execute = getDataSet(dc);
//        
//        Map<Column, TypeConverter<?, ?>> map = discoverPossibleConverters(dc);
//
//        ColumnType[] columnsTypes = new ColumnType[dc.getDefaultSchema().getTables()[0].getColumnCount()];
//        for (int i = 0; i < columnsTypes.length; i++) {
//            columnsTypes[i] = ColumnType.STRING;
//
//        }
//
//        for (Map.Entry<Column, TypeConverter<?, ?>> entrySet : map.entrySet()) {
//            Column key = entrySet.getKey();
//
//            TypeConverter<? extends Object, ? extends Object> value = entrySet.getValue();
//            if (value.getClass().toString().contains("Boolean")) {
//                columnsTypes[key.getColumnNumber()] = ColumnType.BOOLEAN;
//            } else if (value.getClass().toString().contains("Integer")) {
//                columnsTypes[key.getColumnNumber()] = ColumnType.INTEGER;
//            }
//        }
//        
//        String[] columnNames = dc.getDefaultSchema().getTables()[0].getColumnNames();
//        SimpleTableDef std = new SimpleTableDef("DEFAULT_TABLE_NAME", columnNames, columnsTypes);
//        List<Object[]> list = new ArrayList<>();
//        
//        for (Row ex : execute) {
//            Object[] obj = new Object[columnNames.length];
//            for(int i = 0; i < columnNames.length; i++){
//
//                if(columnsTypes[i].equals(ColumnType.INTEGER)){
//                    obj[i] = Integer.valueOf(ex.getValues()[i].toString());
//                }else if(columnsTypes[i].equals(ColumnType.BOOLEAN)){
//                    obj[i] = Boolean.valueOf(ex.getValues()[i].toString());
//                }else{
//                    obj[i] = ex.getValues()[i];
//                }
//            }
//            list.add(obj);
//        }
//    
//        
//
//        TableDataProvider<?> tableDataProvider = new ArrayTableDataProvider(std, list);
//        dataContext = new PojoDataContext("DEFAULT_SCHEMA_NAME", tableDataProvider);
//        return null;
//    }
//
//    private Map<Column, TypeConverter<?, ?>> discoverPossibleConverters(DataContext dc) {
//        Map<Column, TypeConverter<?, ?>> map = Converters.autoDetectConverters(dc, dc.getDefaultSchema().getTables()[0].getColumns(), 10);
//        return map;
//    }
//
//    private DataSet getDataSet(DataContext dc) {
//        DataSet execute = dc.query().from(dc.getDefaultSchema().getTable(0)).selectAll().execute();
//        return execute;
//    }
}

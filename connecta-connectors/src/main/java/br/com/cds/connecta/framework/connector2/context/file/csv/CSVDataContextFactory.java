package br.com.cds.connecta.framework.connector2.context.file.csv;

import br.com.cds.connecta.framework.connector2.common.QueryContext;
import br.com.cds.connecta.framework.connector2.common.FileContextFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.util.FileHelper;

/**
 *
 * @author diego
 */
public class CSVDataContextFactory implements FileContextFactory{

    DataContext dataContext;
    
    QueryContext queryContext;

    String csv;
    
    File file;

    char separatorChar = ',';

    char quoteChar = '\"';


    public CSVDataContextFactory(String csv) {
        this.csv = csv;
        InputStream inputStream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));
        dataContext = DataContextFactory.createCsvDataContext(inputStream, separatorChar, quoteChar);
    }
    
    public CSVDataContextFactory(File file) {
        this.file = file;
        dataContext = DataContextFactory.createCsvDataContext(file, separatorChar, quoteChar, FileHelper.UTF_8_ENCODING);
    }

    @Override
    public DataContext createDataContext() {
        return dataContext;
    }
}

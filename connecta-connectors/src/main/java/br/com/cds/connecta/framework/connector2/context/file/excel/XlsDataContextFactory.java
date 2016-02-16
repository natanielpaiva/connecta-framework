package br.com.cds.connecta.framework.connector2.context.file.excel;

import br.com.cds.connecta.framework.connector2.common.FileContextFactory;
import java.io.File;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.excel.ExcelDataContext;

/**
 *
 * @author diego
 */
public class XlsDataContextFactory implements FileContextFactory {

    DataContext dataContext;

    File file;

    public XlsDataContextFactory(File file) {
        this.file = file;
    }
    
    @Override
    public DataContext createDataContext() {
        dataContext = new ExcelDataContext(file);
        return dataContext;
    }
}

package br.com.cds.connecta.framework.connector2.context.file.xml;

import br.com.cds.connecta.framework.connector2.common.FileContextFactory;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import java.io.File;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.xml.XmlSaxDataContext;
import org.apache.metamodel.xml.XmlSaxTableDef;

/**
 *
 * @author diego
 */
public class XMLDataContextFactory  implements FileContextFactory{

    DataContext dataContext;
    
    QueryBuilder queryContext;

    public File file;

    public String rowPath;

    public String[] valuePath;

    public XMLDataContextFactory(File file, String rowPath, String[] valuePath) {
        this.file = file;
        this.rowPath = rowPath;
        this.valuePath = valuePath;
    }

    @Override
    public DataContext createDataContext() {
        dataContext = new XmlSaxDataContext(file, new XmlSaxTableDef(rowPath, valuePath));
        return dataContext;
    }
}

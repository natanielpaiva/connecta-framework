package br.com.cds.connecta.framework.connector2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author diego
 */
public class TestUtil {
    
    private static final String TEST_RESOURCE_FOLDER = "src/test/resources/";
    private static final String FILE_CHARSET = "UTF-8";
    
    private static final Logger logger = Logger.getLogger(TestUtil.class);
    
    public static String getTestResourceAsString(String fileName) {
        try {
            InputStream is = getTestResource(fileName);
            return IOUtils.toString(is, FILE_CHARSET);
        } catch (IOException ex) {
            logger.error("Erro ao buscar arquivo " + fileName, ex);
        }
        return null;
    }

    public static FileInputStream getTestResource(String fileName) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(TEST_RESOURCE_FOLDER.concat(fileName));
            return fileInputStream;
        } catch (FileNotFoundException ex) {
            logger.error("Arquivo não encontrado: " + fileName, ex);
        }
        return fileInputStream;
    }
}

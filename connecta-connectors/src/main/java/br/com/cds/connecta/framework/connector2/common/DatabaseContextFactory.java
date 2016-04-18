package br.com.cds.connecta.framework.connector2.common;

/**
 *
 * @author diego
 */
public interface DatabaseContextFactory {
    
    String[] getSchemas();
    String[] getTables();
    
}

package br.com.cds.connecta.framework.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 
 * 
 * 
 * Classe Utilitária para leitura de arquivo de propriedades.
 *
 */
public class PropertiesUtil {
	
	private ResourceBundle bundle = null;
	
	public PropertiesUtil(String filename){
		
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
		try {
			bundle = new PropertyResourceBundle(in);
		} catch (IOException e) {
			throw new IllegalAccessError("File not found: ".concat(filename));
		}
	}
	
	protected ResourceBundle getBundle() {
		return bundle;
	}
	
	public String getValueMessages(String key) {
		return getBundle().getString(key);		
	}

}

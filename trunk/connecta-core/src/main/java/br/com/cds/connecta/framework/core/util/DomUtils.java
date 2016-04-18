package br.com.cds.connecta.framework.core.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class DomUtils {
	
	/**
	 * 
	 * @param strxml
	 * @return retorna um document a partir de uma string
	 */
	public static Document converterStringToDocumentXML(String strxml){
		
		Document xml = null;
		
		InputSource source = new InputSource();
	    source.setCharacterStream(new StringReader(strxml));
	        
	    try{
	    		
	        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
	        DocumentBuilder build = fac.newDocumentBuilder();
	        xml = build.parse(source);
	        
	    }catch(SAXException ex){
	    	System.out.println(ex);
	    }catch(IOException ex){
	    	System.out.println(ex);
	    }catch(ParserConfigurationException ex){
	    	System.out.println(ex);
	    }
		
		return xml;
	}

}

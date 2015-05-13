package br.com.cds.connecta.framework.connector.endeca.service;

import br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2.Manage;
import br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2.ManagePort;
import br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3.SConfig;
import br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3.SConfigPort;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3.Conversation;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3.ConversationPort;
import java.net.MalformedURLException;
import java.net.URL;

//import com.endeca.endeca_server.manage._2.Manage;
//import com.endeca.endeca_server.manage._2.ManagePort;
//import com.endeca.endeca_server.sconfig._3.SConfig;
//import com.endeca.endeca_server.sconfig._3.SConfigPort;
//import com.endeca.mdex.conversation._3.Conversation;
//import com.endeca.mdex.conversation._3.ConversationPort;

//TODO substituir System.err por arquivo com Logger
public final class EndecaServiceFactory {
	
	private EndecaServiceFactory(){}
	
	//private final static String serviceUrl = "http://172.16.0.246:7001/endeca-server/ws/";
	
	/**
	 * Get Port Service from Endeca manage
	 * @param wsdlLocation location wsdl service
	 * @return
	 */
	public static ManagePort getManagerService(String wsdlLocation){
		wsdlLocation = EndecaServiceFactory.getWsdlLocation(wsdlLocation);
		
		String url = wsdlLocation + "manage?wsdl";
		ManagePort port = null;
		
		try{
			Manage manager = new Manage(new URL(url));
			port = manager.getManagePort();
		}catch(MalformedURLException e){
			System.err.println("Url não encontrada ou serviço inacessível : " + url);
			e.printStackTrace();
		}
		
		return port;
	}
	
	/**
	 * Get Port Conversation Service of a specific domain
	 * @param dataDomain domain name endeca service
	 * @param wsdlLocation location wsdl service
	 * @return
	 */
	public static ConversationPort getConversationService(String dataDomain, String wsdlLocation){
		wsdlLocation = EndecaServiceFactory.getWsdlLocation(wsdlLocation);
		
		String url = wsdlLocation + "conversation/"+dataDomain+"?wsdl";
		ConversationPort port = null;
		
		try{
		    Conversation conversation = new Conversation(new URL(url));
		    port = conversation.getConversationPort();
		}catch(MalformedURLException e){
			System.err.println("Url não encontrada ou serviço inacessível : " + url);
			e.printStackTrace();
		}
		
		return port;
	}
	
	/**
	 * Get Port Sconfig Service of a specific domain
	 * @param dataDomain
	 * @param wsdlLocation location wsdl service
	 * @return
	 */
	public static SConfigPort getSConfigService(String dataDomain, String wsdlLocation){
		wsdlLocation = EndecaServiceFactory.getWsdlLocation(wsdlLocation);
		
		String url = wsdlLocation + "sconfig/"+dataDomain+"?wsdl";
		SConfigPort port = null;
		
		try{
		    SConfig config = new SConfig(new URL(url));
	        port = config.getSConfigPort();
	    }catch(MalformedURLException e){
	    	System.err.println("Url não encontrada ou serviço inacessível : " + url);
			e.printStackTrace();
	    }
	    
	    return port;
	}
	
    private static String getWsdlLocation(String wsdlLocation){
    	if(wsdlLocation != null && !wsdlLocation.isEmpty()){
			if(!wsdlLocation.endsWith("/")){
				wsdlLocation += "/";
			}
		}
    	
    	return wsdlLocation;
    }
	
}

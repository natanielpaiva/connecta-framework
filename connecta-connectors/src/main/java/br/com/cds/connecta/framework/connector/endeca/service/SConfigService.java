package br.com.cds.connecta.framework.connector.endeca.service;

import br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3.SConfigFault;
import br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3.SConfigPort;
import br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0.CollectionAttribute;
import br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0.CollectionRecord;
import java.util.ArrayList;
import java.util.List;

//import com.endeca.endeca_server.sconfig._3.SConfigFault;
//import com.endeca.endeca_server.sconfig._3.SConfigPort;
//import com.endeca.endeca_server.sconfig._3._0.CollectionAttribute;
//import com.endeca.endeca_server.sconfig._3._0.CollectionRecord;

/**
 * SConfigService is a class that call,
 * sconfig webservice from endeca server,
 *  
 *  this service can be found at the following url 
 *  http://0.0.0.0:7001/endeca-server/ws/sconfig/myDomain?wsdl
 * 
 * @author jhonatas
 *
 */
public class SConfigService {

	private SConfigPort portService;
	
	/**
	 * 
	 * @param dataDomain
	 * @param wsdlLocation localização do wsdl
	 */
	public SConfigService(String dataDomain, String wsdlLocation){
		portService = EndecaServiceFactory.getSConfigService(dataDomain, wsdlLocation);
	}
	
	/**
	 * search all columns from a domain
	 * 
	 * @return List<String> with all columns name from a domain
	 * @throws ServiceFault
	 */
	public List<String> getDomainColumns() throws ServiceFault{
		List<String> columns = new ArrayList<String>();
			
	    try{
			List<CollectionRecord> lista = portService.listCollections(null, "en");
			
			for(CollectionRecord col : lista){
				List<CollectionAttribute> attrs = col.getCollectionAttributes()
				                                     .getCollectionAttribute();
				
				for(CollectionAttribute attr : attrs)
					columns.add(attr.getPropertyKey());
			}
				
	    }catch(SConfigFault e){
	    	throw new ServiceFault(e.getMessage(), e);
	    }
		
	    return columns;
	}
	
	
	public static void main(String... args) throws Exception{
		System.out.println(new SConfigService("COR_RJ", "http://172.16.0.246:7001/endeca-server/ws/").getDomainColumns());		
	}
	
}

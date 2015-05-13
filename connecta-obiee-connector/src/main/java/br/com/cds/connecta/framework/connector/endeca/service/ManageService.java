package br.com.cds.connecta.framework.connector.endeca.service;

import br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2.ManageFault;
import br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2.ManagePort;
import br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0.DataDomainDetail;
import java.util.ArrayList;
import java.util.List;

//import com.endeca.endeca_server.manage._2.ManageFault;
//import com.endeca.endeca_server.manage._2.ManagePort;
//import com.endeca.endeca_server.types._2._0.DataDomainDetail;

/**
 * ManageService is a class that call,
 * manage webservice from endeca server,
 *  
 *  this service can be found at the following url 
 *  http://0.0.0.0:7001/endeca-server/ws/manage?wsdl
 * 
 * @author jhonatas
 *
 */
public class ManageService {

	private ManagePort portService;
	
	/**
	 * @param wsdlLocation localização do wsdl
	 */
	public ManageService(String wsdlLocation){
		portService = EndecaServiceFactory.getManagerService(wsdlLocation);
	}
	
	/**
	 * @return List<String> with all domains name
	 * @throws ServiceFault if it happens any error on webservice, it will throw a ServiceFault Exception
	 */
	public List<String> listDomains() throws ServiceFault{
		List<String> allDomains = new ArrayList<String>();
		
		try{
			List<DataDomainDetail> domains = portService.listDataDomains();
			
			for(DataDomainDetail data : domains)
				allDomains.add(data.getName());
			
		}catch(ManageFault e){
			throw new ServiceFault("Falha ao acessar serviço", e);
		}
		
		return allDomains;
	}
	
}


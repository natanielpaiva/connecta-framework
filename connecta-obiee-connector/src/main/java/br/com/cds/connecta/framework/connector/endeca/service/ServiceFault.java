package br.com.cds.connecta.framework.connector.endeca.service;

public class ServiceFault extends Exception{

	private static final long serialVersionUID = -1792284935552415988L;

	public ServiceFault(String message){
		super(message);
	}
	
	public ServiceFault(String message, Throwable e){
        super(message, e);
	}
	
}

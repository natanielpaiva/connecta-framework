package br.com.cds.connecta.framework.connector.endeca.service.bean;

public class Attribute {

	private String name;
	private String type;
	private Object value;
	
	public Attribute(String name, String type, Object value){
		this.name = name;
		this.type = type;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Object getValue() {
		return value;
	}

}

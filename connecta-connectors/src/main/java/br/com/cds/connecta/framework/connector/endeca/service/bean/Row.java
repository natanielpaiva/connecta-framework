package br.com.cds.connecta.framework.connector.endeca.service.bean;

import java.util.List;

public class Row {

	private List<Attribute> attributes;

	public Row(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Attribute> getAttributes(){
		return attributes;
	}

}

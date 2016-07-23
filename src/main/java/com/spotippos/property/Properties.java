package com.spotippos.property;

import java.util.List;

public class Properties {

	Integer foundProperties;
	
	List<Property> properties;
	
	public Properties(List<Property> properties) {
		super();
		this.properties = properties;
		this.foundProperties = properties.size();
	}
	
	public Integer getFoundProperties() {
		return foundProperties;
	}
	
	public void setFoundProperties(Integer foundProperties) {
		this.foundProperties = foundProperties;
	}
	
	public List<Property> getProperties() {
		return properties;
	}
	
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
}
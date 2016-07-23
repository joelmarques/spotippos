package com.spotippos.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseStatusEnum {
	
	SUCCESS(1, "Success"),
	ERROR(0, "Error");
	
	private int code;
	private String description;
	
	private ResponseStatusEnum(final int code, final String description) {
		this.code = code;
		this.description = description;
	}
	
	@JsonValue
	public String getDescription() {
		return description;
	}
	
	public int getCode() {
		return code;
	}
	
	@JsonCreator
	public static ResponseStatusEnum getAsObject(String description) {
		
		for (ResponseStatusEnum status : ResponseStatusEnum.values()) {
			if (status.getDescription().equalsIgnoreCase(description)) {
				return status;
			}
		}
		
		return null;
	}
}
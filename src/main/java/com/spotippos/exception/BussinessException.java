package com.spotippos.exception;

public class BussinessException extends RuntimeException {
	
	private static final long serialVersionUID = -5732945356371851575L;

	public BussinessException(String message) {
        super(message);
    }

}
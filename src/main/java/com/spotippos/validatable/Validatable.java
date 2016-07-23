package com.spotippos.validatable;

import com.spotippos.exception.BussinessException;

public interface Validatable {
	
	public void validate() throws BussinessException;
}
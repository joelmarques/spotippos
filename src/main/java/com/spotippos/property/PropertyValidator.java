package com.spotippos.property;

import java.math.BigDecimal;

import com.spotippos.exception.BussinessException;
import com.spotippos.validatable.Validatable;

public class PropertyValidator implements Validatable {
	
	Property property;
	
	public PropertyValidator(Property property) {
		this.property = property;
	}

	@Override
	public void validate() throws BussinessException {
		
		if (!this.validRequiredFields()) {
			throw new BussinessException("Todos os campos são obrigatórios");
		}
		
		if (!this.validBeds()) {
			throw new BussinessException("É permitido o cadastro de no máximo " + MAX_BEDS + " quartos (beds), e no mínimo " + MIN_BEDS);
		}
		
		if (!this.validBaths()) {
			throw new BussinessException("É permitido o cadastro de no máximo " + MAX_BATHS + " banheiros (baths), e no mínimo " + MIN_BATHS);
		}
		
		if (!this.validSquareMeters()) {
			throw new BussinessException("É permitido o cadastro de no máximo " + MAX_SQUARE_METERS + " metros quadrados, e no mínimo " + MIN_SQUARE_METERS);
		}
		
	}
	
	private boolean isNotBlank(String value) {
		return value != null && !value.trim().isEmpty();
	}
	
	private boolean isNotNull(Object value) {
		return value != null;
	}
	
	public boolean validRequiredFields() {
		return this.isNotNull(this.property.getX()) && 
				this.isNotNull(this.property.getY()) && 
				this.isNotBlank(this.property.getTitle()) &&
				this.isNotNull(this.property.getPrice()) &&
				this.isNotBlank(this.property.getDescription()) &&
				this.isNotNull(this.property.getBeds()) &&
				this.isNotNull(this.property.getBaths()) && 
				this.isNotNull(this.property.getSquareMeters());
	}

	static final int MIN_BEDS = 1;
	static final int MAX_BEDS = 5;
	static final int MIN_BATHS = 1;
	static final int MAX_BATHS = 4;
	static final BigDecimal MIN_SQUARE_METERS = new BigDecimal(20);
	static final BigDecimal MAX_SQUARE_METERS = new BigDecimal(240);

	private boolean between(int value, int min, int max) {
		return min <= value && value <= max;
	}

	private boolean between(BigDecimal value, BigDecimal min, BigDecimal max) {
		return this.biggerOrEqual(value, min) && this.lessOrEqual(value, max);
	}

	private boolean biggerOrEqual(BigDecimal value, BigDecimal value2) {
		return value.compareTo(value2) >= 0;
	}

	private boolean lessOrEqual(BigDecimal value, BigDecimal value2) {
		return value.compareTo(value2) <= 0;
	}

	public boolean validBeds() {
		return this.between(this.property.getBeds(), MIN_BEDS, MAX_BEDS);
	}

	public boolean validBaths() {
		return this.between(this.property.getBaths(), MIN_BATHS, MAX_BATHS);
	}

	public boolean validSquareMeters() {
		return this.between(this.property.getSquareMeters(), MIN_SQUARE_METERS, MAX_SQUARE_METERS);
	}

}
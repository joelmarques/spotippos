package com.spotippos.province;

import com.spotippos.province.IProvinces.ICoordinate;

public class Coordinate implements ICoordinate {
	
	Integer x;
	Integer y;
	
	public Coordinate(Integer x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public Integer getX() {
		return x;
	}

	@Override
	public Integer getY() {
		return y;
	}
	
}
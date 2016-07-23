package com.spotippos.province;

public interface IProvinces {

	IProvince getGode();
	IProvince getRuja();
	IProvince getJaby();
	IProvince getScavy();
	IProvince getGroola();
	IProvince getNova();

	public interface IProvince {
		IBoundaries getBoundaries();
		boolean has(int x, int y);
	}

	public interface IBoundaries {
		ICoordinate getUpperLeft();
		ICoordinate getBottomRight();
		boolean has(int x, int y);
	}
	
	public interface ICoordinate {
		Integer getX();
		Integer getY();
	}
}
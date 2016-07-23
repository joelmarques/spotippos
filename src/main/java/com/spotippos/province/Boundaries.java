package com.spotippos.province;

import com.spotippos.province.IProvinces.IBoundaries;
import com.spotippos.province.IProvinces.ICoordinate;

public class Boundaries implements IBoundaries {
	
	ICoordinate upperLeft;
	ICoordinate bottomRight;
	
	public Boundaries(Integer ax, Integer ay, Integer bx, Integer by) {
		this.upperLeft = new Coordinate(ax, ay);
		this.bottomRight = new Coordinate(bx, by);
	}

	@Override
	public ICoordinate getUpperLeft() {
		return upperLeft;
	}

	@Override
	public ICoordinate getBottomRight() {
		return bottomRight;
	}
	
	private boolean between(int value, int min, int max) {
		return min <= value && value <= max;
	}

	@Override
	public boolean has(int x, int y) {
		
		int Xmin = this.upperLeft.getX() < this.bottomRight.getX() ? this.upperLeft.getX() : this.bottomRight.getX();
		int Xmax = this.upperLeft.getX() > this.bottomRight.getX() ? this.upperLeft.getX() : this.bottomRight.getX();
		
		int Ymin = this.upperLeft.getY() < this.bottomRight.getY() ? this.upperLeft.getY() : this.bottomRight.getY();
		int Ymax = this.upperLeft.getY() > this.bottomRight.getY() ? this.upperLeft.getY() : this.bottomRight.getY();
		
		return this.between(x, Xmin, Xmax) && this.between(y, Ymin, Ymax);
	}
	
}
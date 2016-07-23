package com.spotippos.province;

import com.spotippos.province.IProvinces.IBoundaries;
import com.spotippos.province.IProvinces.IProvince;

public class Province implements IProvince {

	IBoundaries boundaries;
	
	public Province(Integer ax, Integer ay, Integer bx, Integer by) {
		super();
		this.boundaries = new Boundaries(ax, ay, bx, by);
	}

	@Override
	public IBoundaries getBoundaries() {
		return boundaries;
	}
	
	@Override
	public boolean has(int x, int y) {
		return this.boundaries.has(x, y);
	}

}
package com.spotippos.province;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Provinces implements IProvinces {
	
	@JsonProperty("Gode")
	IProvince gode;
	
	@JsonProperty("Ruja")
	IProvince ruja;
	
	@JsonProperty("Jaby")
	IProvince jaby;
	
	@JsonProperty("Scavy")
	IProvince scavy;
	
	@JsonProperty("Groola")
	IProvince groola;
	
	@JsonProperty("Nova")
	IProvince nova;
	
	public Provinces() {
		super();
		this.gode = new Province(0, 1000, 600, 500);
		this.ruja = new Province(400, 1000, 1100, 500);
		this.jaby = new Province(1100, 1000, 1400, 500);
		this.scavy = new Province(0, 500, 600, 0);
		this.groola = new Province(600, 500, 800, 0);
		this.nova = new Province(800, 500, 1400, 0);
	}

	@Override
	public IProvince getGode() {
		return gode;
	}

	@Override
	public IProvince getRuja() {
		return ruja;
	}

	@Override
	public IProvince getJaby() {
		return jaby;
	}

	@Override
	public IProvince getScavy() {
		return scavy;
	}

	@Override
	public IProvince getGroola() {
		return groola;
	}

	@Override
	public IProvince getNova() {
		return nova;
	}
	
	public Collection<String> provinces(int x, int y) {
		
		Collection<String> provinces = new ArrayList<String>();
		
		if(this.gode.has(x, y)){
			provinces.add("Gode");
		}
		
		if(this.ruja.has(x, y)){
			provinces.add("Ruja");
		}
		
		if(this.jaby.has(x, y)){
			provinces.add("Jaby");
		}
		
		if(this.scavy.has(x, y)){
			provinces.add("Scavy");
		}
		
		if(this.groola.has(x, y)){
			provinces.add("Groola");
		}
		
		if(this.nova.has(x, y)){
			provinces.add("Nova");
		}
		
		return provinces;
	}

}
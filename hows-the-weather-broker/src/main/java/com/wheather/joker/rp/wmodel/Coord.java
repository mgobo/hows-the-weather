package com.wheather.joker.rp.wmodel;

import java.io.Serializable;

public class Coord implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double lon;
	private Double lat;
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	
}

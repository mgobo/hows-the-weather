package com.wheather.joker.rp.wmodel;

import java.io.Serializable;

public class Wind implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double speed;
	private long deg;
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public long getDeg() {
		return deg;
	}
	public void setDeg(long deg) {
		this.deg = deg;
	}
}

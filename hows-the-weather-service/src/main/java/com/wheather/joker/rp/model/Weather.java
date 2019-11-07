package com.wheather.joker.rp.model;

import java.io.Serializable;

public class Weather implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String main;
	private String description;
	private String icon;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}

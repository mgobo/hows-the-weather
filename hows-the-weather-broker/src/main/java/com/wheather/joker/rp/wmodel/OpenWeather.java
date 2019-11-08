package com.wheather.joker.rp.wmodel;

import java.io.Serializable;

public class OpenWeather implements Serializable {

	private static final long serialVersionUID = 1L;
	private Coord coord;
	private Weather[] weather;
	private String base;
	private Main main;
	private long visibility;
	private Wind wind;
	private Clouds clouds;
	private long dt;
	private Sys sys;
	private long timezone;
	private long id;
	private String name;
	private long cod;
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	public Weather[] getWeather() {
		return weather;
	}
	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public long getVisibility() {
		return visibility;
	}
	public void setVisibility(long visibility) {
		this.visibility = visibility;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public long getDt() {
		return dt;
	}
	public void setDt(long dt) {
		this.dt = dt;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public long getTimezone() {
		return timezone;
	}
	public void setTimezone(long timezone) {
		this.timezone = timezone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCod() {
		return cod;
	}
	public void setCod(long cod) {
		this.cod = cod;
	}
}

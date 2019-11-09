package com.wheather.joker.rp.model;

import com.wheather.joker.rp.wmodel.OpenWeather;

public class DataOpenWeather {

	private Long data_id;
	private String city;
	private String geopoints;
	private String zipCode;
	private Long cityId;
	private String result;
	
	private OpenWeather openWeather;
	public Long getData_id() {
		return data_id;
	}
	public void setData_id(Long data_id) {
		this.data_id = data_id;
	}
	public OpenWeather getOpenWeather() {
		return openWeather;
	}
	public void setOpenWeather(OpenWeather openWeather) {
		this.openWeather = openWeather;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGeopoints() {
		return geopoints;
	}
	public void setGeopoints(String geopoints) {
		this.geopoints = geopoints;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}

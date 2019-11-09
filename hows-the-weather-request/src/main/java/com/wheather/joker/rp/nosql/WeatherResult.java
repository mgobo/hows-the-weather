package com.wheather.joker.rp.nosql;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weather-result")
public class WeatherResult {

	private Long id;
	private String result;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}

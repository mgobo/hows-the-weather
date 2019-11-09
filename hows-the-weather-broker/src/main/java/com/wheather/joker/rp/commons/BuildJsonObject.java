package com.wheather.joker.rp.commons;

import com.google.gson.Gson;
import com.wheather.joker.rp.model.DataOpenWeather;

public class BuildJsonObject<T> {

	public String buildResult(DataOpenWeather dataOpenWeather) {
		Gson gson 		= new Gson();
		String result 	= gson.toJson(dataOpenWeather);
		return result;
	}
	
	public T buildToObject(String json, Class<T> clazz) {
		Gson gson 		= new Gson();
		return (T) gson.fromJson(json, clazz);
	}
}

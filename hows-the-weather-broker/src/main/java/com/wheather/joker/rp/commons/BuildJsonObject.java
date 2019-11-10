package com.wheather.joker.rp.commons;

import com.google.gson.Gson;

public class BuildJsonObject<T> {

	public String buildResult(Object data) {
		Gson gson 		= new Gson();
		String result 	= gson.toJson(data);
		return result;
	}
	
	public T buildToObject(String json, Class<T> clazz) {
		Gson gson 		= new Gson();
		return (T) gson.fromJson(json, clazz);
	}
}

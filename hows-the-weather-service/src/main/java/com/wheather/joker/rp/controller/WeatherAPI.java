package com.wheather.joker.rp.controller;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.wheather.joker.rp.commons.BuildJsonObject;
import com.wheather.joker.rp.model.DataOpenWeather;
import com.wheather.joker.rp.wmodel.OpenWeather;

@Component
public class WeatherAPI {
	
	private final String API_KEY = "eb8b1a9405e659b2ffc78f0a520b1a46";
	private String API_CALL = "https://api.openweathermap.org/data/2.5/weather?";
	
	public String city(DataOpenWeather dataOpenWeather, BuildJsonObject<DataOpenWeather> build) throws RestClientException{
		RestTemplate restTemplate = new RestTemplate();
		API_CALL+="q="+dataOpenWeather.getCity()+"&appid="+API_KEY;
		OpenWeather openWeather = Optional.ofNullable(restTemplate.getForObject(API_CALL, OpenWeather.class))
			    					      .orElseThrow(()->new RestClientException("Wheater for city ["+dataOpenWeather.getCity()+"] was not found..."));
		dataOpenWeather.setOpenWeather(openWeather);
		dataOpenWeather.setResult("Weather was found using your city "+dataOpenWeather.getCity());
		return build.buildResult(dataOpenWeather);
	}
	
	public String geopoints(DataOpenWeather dataOpenWeather, BuildJsonObject<DataOpenWeather> build) throws RestClientException{
		RestTemplate restTemplate = new RestTemplate();
		String lat = dataOpenWeather.getGeopoints().split(",")[0];
		String lon = dataOpenWeather.getGeopoints().split(",")[1];
		API_CALL+="lat="+lat+"&lon="+lon+"&appid="+API_KEY;
		OpenWeather openWeather = Optional.ofNullable(restTemplate.getForObject(API_CALL, OpenWeather.class))
			    					      .orElseThrow(()->new RestClientException("Wheater for geopoints ["+lat+","+lon+"] was not found..."));
		
		dataOpenWeather.setOpenWeather(openWeather);
		dataOpenWeather.setResult("Weather was found using your location ["+lat+","+lon+"]");
		return build.buildResult(dataOpenWeather);
	}
	
	public String zipcode(DataOpenWeather dataOpenWeather, BuildJsonObject<DataOpenWeather> build) throws RestClientException{
		RestTemplate restTemplate = new RestTemplate();
		API_CALL+="zip="+dataOpenWeather.getZipCode()+"&appid="+API_KEY;
		OpenWeather openWeather = Optional.ofNullable(restTemplate.getForObject(API_CALL, OpenWeather.class))
			    					      .orElseThrow(()->new RestClientException("Wheater for zipcode ["+dataOpenWeather.getZipCode()+"] was not found..."));
		
		dataOpenWeather.setOpenWeather(openWeather);
		dataOpenWeather.setResult("Weather was found using your zipcode "+dataOpenWeather.getZipCode());
		return build.buildResult(dataOpenWeather);
	}
	
	public String cityId(DataOpenWeather dataOpenWeather, BuildJsonObject<DataOpenWeather> build) throws RestClientException{
		RestTemplate restTemplate = new RestTemplate();
		API_CALL+="id="+dataOpenWeather.getCityId()+"&appid="+API_KEY;
		OpenWeather openWeather = Optional.ofNullable(restTemplate.getForObject(API_CALL, OpenWeather.class))
			    					      .orElseThrow(()->new RestClientException("Wheater for id city ["+dataOpenWeather.getCityId()+"] was not found..."));
		
		dataOpenWeather.setOpenWeather(openWeather);
		dataOpenWeather.setResult("Weather was found using your id city "+dataOpenWeather.getCityId());
		return build.buildResult(dataOpenWeather);
	}
}

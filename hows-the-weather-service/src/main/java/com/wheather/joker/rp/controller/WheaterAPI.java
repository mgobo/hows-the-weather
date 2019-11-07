package com.wheather.joker.rp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.wheather.joker.rp.model.OpenWeather;

@RequestMapping(path="/weather")
@RestController
public class WheaterAPI {
	
	@Autowired
	private RestTemplate restTemplate;
	private final String API_KEY = "";
	private String API_CALL = "api.openweathermap.org/data/2.5/weather?";
	
	private String buildResult(OpenWeather openWeather) {
		Gson gson 		= new Gson();
		String result 	= gson.toJson(openWeather);
		return result;
	}
	
	@GetMapping(path = "/city/{name}/{apikey}")
	public ResponseEntity<String> city(@PathVariable("name")String name,
									   @PathVariable("country")String country){
		API_CALL+="q="+name+","+country+"&appid="+API_KEY;
		OpenWeather openWeather = Optional.ofNullable(restTemplate.getForObject(API_CALL, OpenWeather.class))
			    					      .orElseThrow(()->new RuntimeException("Wheater for city ["+name+"] was not found..."));
		
		return ResponseEntity.ok(this.buildResult(openWeather));
	}
	
	@GetMapping(path = "/geopoints/{lat}/{long}/{apikey}")
	public ResponseEntity<String> geopoints(@PathVariable("lat")String lat,
									        @PathVariable("lgt") String lgt){
		API_CALL+="lat="+lat+"&lon="+lgt+"&appid="+API_KEY;
		OpenWeather openWeather = Optional.ofNullable(restTemplate.getForObject(API_CALL, OpenWeather.class))
			    					      .orElseThrow(()->new RuntimeException("Wheater for geopoints ["+lat+","+lgt+"] was not found..."));
		
		return ResponseEntity.ok(this.buildResult(openWeather));
	}
	
	@GetMapping(path = "/zipcode/{zipcode}/{apikey}")
	public ResponseEntity<String> zipcode(@PathVariable("zipcode")String zipcode){
		API_CALL+="zip="+zipcode+"&appid="+API_KEY;
		OpenWeather openWeather = Optional.ofNullable(restTemplate.getForObject(API_CALL, OpenWeather.class))
			    					      .orElseThrow(()->new RuntimeException("Wheater for zipcode ["+zipcode+"] was not found..."));
		
		return ResponseEntity.ok(this.buildResult(openWeather));
	}
	
	@GetMapping(path = "/cityId/{id}/{apikey}")
	public ResponseEntity<String> cityId(@PathVariable("id")String id){
		API_CALL+="id="+id+"&appid="+API_KEY;
		OpenWeather openWeather = Optional.ofNullable(restTemplate.getForObject(API_CALL, OpenWeather.class))
			    					      .orElseThrow(()->new RuntimeException("Wheater for id city ["+id+"] was not found..."));
		
		return ResponseEntity.ok(this.buildResult(openWeather));
	}
}

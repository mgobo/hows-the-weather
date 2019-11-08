package com.wheather.joker.rp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wheather.joker.rp.bqueue.BrokerQ;
import com.wheather.joker.rp.model.DataOpenWeather;
import com.wheather.joker.rp.wmodel.OpenWeather;

@RequestMapping(path = "howstheweather")
@RestController
public class HowsTheWeather {

	@Autowired
	private BrokerQ brokerQ;
	private static final Gson GSON = new Gson();
	
	@GetMapping(path = "/city/{name}")
	public ResponseEntity<String> city(@PathVariable("name")String name,
									   @PathVariable("country")String country) throws Exception{
		DataOpenWeather dataOpenWeather = new DataOpenWeather();
		dataOpenWeather.setData_id(System.currentTimeMillis());
		dataOpenWeather.setCity(name+","+country);
		
		String json = GSON.toJson(dataOpenWeather, DataOpenWeather.class);
		brokerQ.message(json, "city_sent");
		
		return ResponseEntity.ok("Your search about city was scheduled...");
	}
	
	@GetMapping(path = "/geopoints/{lat}/{long}")
	public ResponseEntity<String> geopoints(@PathVariable("lat")String lat,
									        @PathVariable("lgt") String lgt){
		DataOpenWeather dataOpenWeather = new DataOpenWeather();
		dataOpenWeather.setData_id(System.currentTimeMillis());
		dataOpenWeather.setGeopoints(geopoints);
		
		String json = GSON.toJson(dataOpenWeather, DataOpenWeather.class);
		brokerQ.message(json, "geopoints_sent");
		
		return ResponseEntity.ok("Your search about geopoints was scheduled...");
	}
	
	@GetMapping(path = "/zipcode/{zipcode}")
	public ResponseEntity<String> zipcode(@PathVariable("zipcode")String zipcode){
		DataOpenWeather dataOpenWeather = new DataOpenWeather();
		dataOpenWeather.setData_id(System.currentTimeMillis());
		dataOpenWeather.setZipCode(zipcode);;
		
		String json = GSON.toJson(dataOpenWeather, DataOpenWeather.class);
		brokerQ.message(json, "zipcode_sent");
		
		return ResponseEntity.ok("Your search about zipcode was scheduled...");
	}
	
	@GetMapping(path = "/cityId/{id}")
	public ResponseEntity<String> cityId(@PathVariable("id")String id){
		OpenWeather openWeather = Optional.ofNullable(restTemplate.getForObject(API_CALL, OpenWeather.class))
			    					      .orElseThrow(()->new RuntimeException("Wheater for id city ["+id+"] was not found..."));
		
		return ResponseEntity.ok(this.buildResult(openWeather));
	}
	
}

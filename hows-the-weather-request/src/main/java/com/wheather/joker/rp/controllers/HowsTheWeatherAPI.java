package com.wheather.joker.rp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wheather.joker.rp.bqueue.BrokerQ;
import com.wheather.joker.rp.model.DataOpenWeather;

@RequestMapping(path = "howstheweather")
@RestController
public class HowsTheWeatherAPI {

	@Autowired
	private BrokerQ brokerQ;
	private static final Gson GSON = new Gson();
	
	@GetMapping(path = "/city/{name}/{country}")
	public ResponseEntity<String> city(@PathVariable("name")String name,
									   @PathVariable("country")String country) throws Exception{
		DataOpenWeather dataOpenWeather = new DataOpenWeather();
		dataOpenWeather.setData_id(System.currentTimeMillis());
		dataOpenWeather.setCity(name+","+country);
		
		String json = GSON.toJson(dataOpenWeather, DataOpenWeather.class);
		brokerQ.message(json, "city_sent");
		
		return ResponseEntity.ok("Your search about city was scheduled, your code = ["+dataOpenWeather.getData_id()+"]...");
	}
	
	@GetMapping(path = "/geopoints/{lat}/{lgt}")
	public ResponseEntity<String> geopoints(@PathVariable("lat")String lat,
									        @PathVariable("lgt")String lgt) throws Exception{
		DataOpenWeather dataOpenWeather = new DataOpenWeather();
		dataOpenWeather.setData_id(System.currentTimeMillis());
		dataOpenWeather.setGeopoints(lat+","+lgt);
		
		String json = GSON.toJson(dataOpenWeather, DataOpenWeather.class);
		brokerQ.message(json, "geopoints_sent");
		
		return ResponseEntity.ok("Your search about geopoints was scheduled, your code = ["+dataOpenWeather.getData_id()+"]...");
	}
	
	@GetMapping(path = "/zipcode/{zipcode}/{country}")
	public ResponseEntity<String> zipcode(@PathVariable("zipcode")String zipcode,
										  @PathVariable("country")String country) throws Exception{
		DataOpenWeather dataOpenWeather = new DataOpenWeather();
		dataOpenWeather.setData_id(System.currentTimeMillis());
		dataOpenWeather.setZipCode(zipcode+","+country);
		
		String json = GSON.toJson(dataOpenWeather, DataOpenWeather.class);
		brokerQ.message(json, "zipcode_sent");
		
		return ResponseEntity.ok("Your search about zipcode was scheduled, your code = ["+dataOpenWeather.getData_id()+"]");
	}
	
	@GetMapping(path = "/cityId/{id}")
	public ResponseEntity<String> cityId(@PathVariable("id")String id) throws Exception{
		
		DataOpenWeather dataOpenWeather = new DataOpenWeather();
		dataOpenWeather.setData_id(System.currentTimeMillis());
		dataOpenWeather.setCityId(new Long(id));
		
		String json = GSON.toJson(dataOpenWeather, DataOpenWeather.class);
		brokerQ.message(json, "id_sent");
		
		return ResponseEntity.ok("Your search about city id was scheduled, your code = ["+dataOpenWeather.getData_id()+"]");
	}
	
}

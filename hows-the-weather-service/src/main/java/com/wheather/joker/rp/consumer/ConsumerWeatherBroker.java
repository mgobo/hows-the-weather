package com.wheather.joker.rp.consumer;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.wheather.joker.rp.bqueue.BrokerQ;
import com.wheather.joker.rp.commons.BuildJsonObject;
import com.wheather.joker.rp.controller.WeatherAPI;
import com.wheather.joker.rp.model.DataOpenWeather;

@EnableJms
@Component
public class ConsumerWeatherBroker {
	
	@Autowired
	private BrokerQ brokerQ;
	
	@JmsListener(id = "city_sent", concurrency = "5-10", destination = "city_sent")
	public void cityPoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			System.out.println("City_sent: "+msg);
			BuildJsonObject<DataOpenWeather> build = new BuildJsonObject<>();
			DataOpenWeather dataOpenWeather = build.buildToObject(msg, DataOpenWeather.class);
			WeatherAPI weatherAPI = new WeatherAPI();
			
			String json = null;
			try {
				json = weatherAPI.city(dataOpenWeather, build);
				System.out.println(json);
			}catch(RestClientException ex) {
				dataOpenWeather.setResult("Error on request = "+ex.getMessage());
				json = build.buildResult(dataOpenWeather);
			}
			brokerQ.message(json, "city_result");
		}catch(JMSException ex) {
			
		}
	}
	
	@JmsListener(id = "geopoints_sent", concurrency = "5-10", destination = "geopoints_sent")
	public void geopointPoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			System.out.println("Geopoints_sent: "+msg);
			BuildJsonObject<DataOpenWeather> build = new BuildJsonObject<>();
			DataOpenWeather dataOpenWeather = build.buildToObject(msg, DataOpenWeather.class);
			WeatherAPI weatherAPI = new WeatherAPI();
			
			String json = null;
			try {
				json = weatherAPI.geopoints(dataOpenWeather, build);
				System.out.println(json);
			}catch(RestClientException ex) {
				dataOpenWeather.setResult("on request = "+ex.getMessage());
				json = build.buildResult(dataOpenWeather);
			}
			brokerQ.message(json, "geopoints_result");
		}catch(JMSException ex) {
			
		}
	}
	
	@JmsListener(id = "zipcode_sent", concurrency = "5-10", destination = "zipcode_sent")
	public void zipcodePoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			System.out.println("Zipcode_sent: "+msg);
			BuildJsonObject<DataOpenWeather> build = new BuildJsonObject<>();
			DataOpenWeather dataOpenWeather = build.buildToObject(msg, DataOpenWeather.class);
			WeatherAPI weatherAPI = new WeatherAPI();
			
			String json = null;
			try {
				json = weatherAPI.zipcode(dataOpenWeather, build);
				System.out.println(json);
			}catch(RestClientException ex) {
				dataOpenWeather.setResult("Error on request = "+ex.getMessage());
				json = build.buildResult(dataOpenWeather);
			}
			brokerQ.message(json, "zipcode_result");
		}catch(JMSException ex) {
			
		}
	}
	
	@JmsListener(id = "city-id_sent", concurrency = "5-10", destination = "id_sent")
	public void cityIdPoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			System.out.println("CityId_sent: "+msg);
			BuildJsonObject<DataOpenWeather> build = new BuildJsonObject<>();
			DataOpenWeather dataOpenWeather = build.buildToObject(msg, DataOpenWeather.class);
			WeatherAPI weatherAPI = new WeatherAPI();
			
			String json = null;
			try {
				json = weatherAPI.cityId(dataOpenWeather, build);
				System.out.println(json);
			}catch(RestClientException ex) {
				dataOpenWeather.setResult("Error on request = "+ex.getMessage());
				json = build.buildResult(dataOpenWeather);
			}
			brokerQ.message(json, "id_result");
		}catch(JMSException ex) {
			
		}
	}
	
}

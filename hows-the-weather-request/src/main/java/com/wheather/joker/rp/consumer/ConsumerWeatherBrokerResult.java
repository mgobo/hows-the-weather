package com.wheather.joker.rp.consumer;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.wheather.joker.rp.commons.BuildJsonObject;
import com.wheather.joker.rp.model.DataOpenWeather;
import com.wheather.joker.rp.nosql.WeatherResult;

@EnableJms
@Component
public class ConsumerWeatherBrokerResult {
	
	private static final Logger LOGGER = Logger.getLogger(ConsumerWeatherBrokerResult.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
		
	@JmsListener(id = "city_result", concurrency = "5-10", destination = "city_result")
	public void cityPoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			LOGGER.info("Loaded City_result: "+msg);
			BuildJsonObject<DataOpenWeather> build = new BuildJsonObject<>();
			DataOpenWeather dataOpenWeather 	   = build.buildToObject(msg, DataOpenWeather.class);
			try {
				WeatherResult weatherResult = new WeatherResult();
				weatherResult.setId(dataOpenWeather.getData_id());
				weatherResult.setResult(msg);
				this.mongoTemplate.insert(weatherResult);
			}catch (Exception ex) {
				LOGGER.error("Fail on record data result, error = "+ex.getMessage());
			}
		}catch(JMSException ex) {
			LOGGER.error("Fail on broker endpoint result loader, error = "+ex.getMessage());
		}
	}
	
	@JmsListener(id = "geopoints_result", concurrency = "5-10", destination = "geopoints_result")
	public void geopointPoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			LOGGER.info("Loaded Geopoints_result: "+msg);
			BuildJsonObject<DataOpenWeather> build = new BuildJsonObject<>();
			DataOpenWeather dataOpenWeather = build.buildToObject(msg, DataOpenWeather.class);
			try {
				WeatherResult weatherResult = new WeatherResult();
				weatherResult.setId(dataOpenWeather.getData_id());
				weatherResult.setResult(msg);
				this.mongoTemplate.insert(weatherResult);
			}catch (Exception ex) {
				LOGGER.error("Fail on record data result, error = "+ex.getMessage());
			}
		}catch(JMSException ex) {
			LOGGER.error("Fail on broker endpoint result loader, error = "+ex.getMessage());
		}
	}
	
	@JmsListener(id = "zipcode_result", concurrency = "5-10", destination = "zipcode_result")
	public void zipcodePoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			LOGGER.info("Loaded Zipcode_result: "+msg);
			BuildJsonObject<DataOpenWeather> build = new BuildJsonObject<>();
			DataOpenWeather dataOpenWeather = build.buildToObject(msg, DataOpenWeather.class);
			try {
				WeatherResult weatherResult = new WeatherResult();
				weatherResult.setId(dataOpenWeather.getData_id());
				weatherResult.setResult(msg);
				this.mongoTemplate.insert(weatherResult);
			}catch (Exception ex) {
				LOGGER.error("Fail on record data result, error = "+ex.getMessage());
			}
		}catch(JMSException ex) {
			LOGGER.error("Fail on broker endpoint result loader, error = "+ex.getMessage());
		}
	}
	
	@JmsListener(id = "city-id_result", concurrency = "5-10", destination = "id_result")
	public void cityIdPoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			LOGGER.info("Loaded CityId_result: "+msg);
			BuildJsonObject<DataOpenWeather> build = new BuildJsonObject<>();
			DataOpenWeather dataOpenWeather = build.buildToObject(msg, DataOpenWeather.class);
			try {
				WeatherResult weatherResult = new WeatherResult();
				weatherResult.setId(dataOpenWeather.getData_id());
				weatherResult.setResult(msg);
				this.mongoTemplate.insert(weatherResult);
			}catch (Exception ex) {
				LOGGER.error("Fail on record data result, error = "+ex.getMessage());
			}
		}catch(JMSException ex) {
			LOGGER.error("Fail on broker endpoint result loader, error = "+ex.getMessage());
		}
	}
}

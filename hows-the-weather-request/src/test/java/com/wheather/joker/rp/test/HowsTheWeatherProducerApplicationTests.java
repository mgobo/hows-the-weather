package com.wheather.joker.rp.test;

import javax.jms.JMSException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.wheather.joker.rp.bqueue.BrokerQ;
import com.wheather.joker.rp.commons.BuildJsonObject;
import com.wheather.joker.rp.nosql.WeatherResult;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HowsTheWeatherProducerApplicationTests {

	private RestTemplate restTemplate;
	private BuildJsonObject<WeatherResult> result;
	private static final String HOST = "http://localhost:8081/"; 
	
	@Autowired
	private BrokerQ brokerQ;
	
	@Before
	public void beforeClass() {
		this.restTemplate = new RestTemplate();
		try {
			boolean result = this.brokerQ.validateConnection();
			Assert.assertEquals("Test accepted...", true, result);
		}catch(JMSException ex) {
			Assert.fail("Error on connection, error = "+ex.getMessage());
		}
	}
	
	@Test
	public void cityTest() {
		String city 	= "Ribeirao Preto";
		String country	= "SP";
		try {
			WeatherResult weatherResult = this.restTemplate.getForObject(HOST+"city/"+city+"/"+country, WeatherResult.class);
			result						= new BuildJsonObject<>();
			result.buildResult(weatherResult);
			
			Assert.assertEquals("Test accepted", true, result != null);
		}catch(RestClientException ex) {
			Assert.fail("Test rejected, fail = "+ex.getMessage());
		}
	}
	
	@Test
	public void geopointsTest() {
		String lat	= "-47.81";
		String lgt	= "-21.18";
		try {
			WeatherResult weatherResult = this.restTemplate.getForObject(HOST+"geopoints/"+lat+"/"+lgt, WeatherResult.class);
			result						= new BuildJsonObject<>();
			result.buildResult(weatherResult);
			
			Assert.assertEquals("Test accepted", true, result != null);
		}catch(RestClientException ex) {
			Assert.fail("Test rejected, fail = "+ex.getMessage());
		}
	}
	
	@Test
	public void zipCodeTest() {
		String zipcode = "14051220";
		String country = "BR";
		try {
			WeatherResult weatherResult = this.restTemplate.getForObject(HOST+"zipcode/"+zipcode+"/"+country, WeatherResult.class);
			result						= new BuildJsonObject<>();
			result.buildResult(weatherResult);
			
			Assert.assertEquals("Test accepted", true, result != null);
		}catch(RestClientException ex) {
			Assert.fail("Test rejected, fail = "+ex.getMessage());
		}
	}
	
	@Test
	public void cityIdTest() {
		String id      = "3451328";
		try {
			WeatherResult weatherResult = this.restTemplate.getForObject(HOST+"cityId/"+id, WeatherResult.class);
			result						= new BuildJsonObject<>();
			result.buildResult(weatherResult);
			
			Assert.assertEquals("Test accepted", true, result != null);
		}catch(RestClientException ex) {
			Assert.fail("Test rejected, fail = "+ex.getMessage());
		}
	}
}

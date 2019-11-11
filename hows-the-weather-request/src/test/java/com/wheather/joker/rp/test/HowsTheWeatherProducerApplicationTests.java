package com.wheather.joker.rp.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.jms.JMSException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wheather.joker.rp.bqueue.BrokerQ;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HowsTheWeatherProducerApplicationTests {

	private static final String HOST = "/howstheweather/";
	
	@Autowired
	private WebApplicationContext webContext;
	private MockMvc mock;
	
	@Autowired
	private BrokerQ brokerQ;
	
	@Before
	public void beforeClass() {
		try {
			this.mock = MockMvcBuilders.webAppContextSetup(this.webContext).build();
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
			String result = this.mock.perform(get(HOST+"city/"+city+"/"+country))
									 .andExpect(status().isOk())
									 .andReturn().getResponse().getContentAsString();
			
			System.out.println(result);
			Assert.assertEquals("Test accepted", true, result != null);
		}catch(Exception ex) {
			Assert.fail("Test rejected, fail = "+ex.getMessage());
		}
	}
	
	@Test
	public void geopointsTest() {
		String lat	= "-47.81";
		String lgt	= "-21.18";
		try {
			String result = this.mock.perform(get(HOST+"geopoints/"+lat+"/"+lgt))					 
   								     .andExpect(status().isOk())
								     .andReturn().getResponse().getContentAsString();
			
			System.out.println(result);
			Assert.assertEquals("Test accepted", true, result != null);
		}catch(Exception ex) {
			Assert.fail("Test rejected, fail = "+ex.getMessage());
		}
	}
	
	@Test
	public void zipCodeTest() {
		String zipcode = "14051220";
		String country = "BR";
		try {
			String result = this.mock.perform(get(HOST+"zipcode/"+zipcode+"/"+country))
								     .andExpect(status().isOk())
									 .andReturn().getResponse().getContentAsString();

			System.out.println(result);
			Assert.assertEquals("Test accepted", true, result != null);
		}catch(Exception ex) {
			Assert.fail("Test rejected, fail = "+ex.getMessage());
		}
	}
	
	@Test
	public void cityIdTest() {
		String id      = "3451328";
		try {
		     String result = this.mock.perform(get(HOST+"cityId/"+id))
									  .andExpect(status().isOk())
                                      .andReturn().getResponse().getContentAsString();
			
		     System.out.println(result);
			Assert.assertEquals("Test accepted", true, result != null);
		}catch(Exception ex) {
			Assert.fail("Test rejected, fail = "+ex.getMessage());
		}
	}
}

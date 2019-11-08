package com.wheather.joker.rp.consumer;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@EnableJms
@Component
public class ConsumerWeatherBroker {
	
	@JmsListener(id = "city_sent", concurrency = "5-10", destination = "city_sent")
	public void cityPoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			System.out.println("City_sent: "+msg);
		}catch(JMSException ex) {
			
		}
	}
	
	@JmsListener(id = "geopoints_sent", concurrency = "5-10", destination = "geopoints_sent")
	public void geopointPoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			System.out.println("Geopoints_sent: "+msg);
		}catch(JMSException ex) {
			
		}
	}
	
	@JmsListener(id = "zipcode_sent", concurrency = "5-10", destination = "zipcode_sent")
	public void zipcodePoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			System.out.println("Zipcode_sent: "+msg);
		}catch(JMSException ex) {
			
		}
	}
	
	@JmsListener(id = "city-id_sent", concurrency = "5-10", destination = "id_sent")
	public void cityIdPoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
			System.out.println("CityId_sent: "+msg);
		}catch(JMSException ex) {
			
		}
	}
	
}

package com.wheather.joker.rp.consumer;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@EnableJms
@Component
public class ConsumerWeatherBroker {
	
	@JmsListener(id = "city_point", concurrency = "5-10", destination = "city")
	public void cityPoint(TextMessage message) {
		try {
			String msg = message.getBody(String.class);
		}catch(JMSException ex) {
			
		}
	}
	
}

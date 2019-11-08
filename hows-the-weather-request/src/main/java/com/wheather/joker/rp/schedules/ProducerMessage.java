package com.wheather.joker.rp.schedules;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wheather.joker.rp.bqueue.BrokerQ;

@Component
public class ProducerMessage {

	@Autowired
	private BrokerQ brokerQ;
	
	@Autowired
	private JmsTemplate msgTemplate;
	
	@Scheduled(initialDelay = 2000, fixedDelay = 2000)
	public void sendMessage() throws JMSException{
		System.out.println("Sending message");
		this.brokerQ.message("Ribeirao Preto", "city");
		
		this.msgTemplate.convertAndSend("city", "Ribeirao Preto");
	}
}

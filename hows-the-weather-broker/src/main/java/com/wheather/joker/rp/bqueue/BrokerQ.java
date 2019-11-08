package com.wheather.joker.rp.bqueue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

@EnableJms
@Component
public class BrokerQ {

	@Autowired
	private ConnectionFactory connectionFactory;
	
	public void message(String message, String queueName) throws JMSException {
		try(Connection connection = this.connectionFactory.createConnection()){
			connection.setClientID(queueName);
			connection.start();
			try(Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)){
				Queue q = session.createQueue(queueName);
				MessageProducer producer = session.createProducer(q);
				
				TextMessage msg = session.createTextMessage();
				msg.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
				msg.setText(message);
				
				producer.send(msg);//Send Message
				producer.close();
			}
		}
	}
}

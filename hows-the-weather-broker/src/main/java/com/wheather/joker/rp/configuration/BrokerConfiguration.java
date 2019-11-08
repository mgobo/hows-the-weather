package com.wheather.joker.rp.configuration;

import javax.jms.JMSException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class BrokerConfiguration {

	private static final String URL = "tcp://0.0.0.0:61616?tcpSendBufferSize=1048576;tcpReceiveBufferSize=1048576;protocols=CORE,AMQP,STOMP,HORNETQ,MQTT,OPENWIRE;useEpoll=true;amqpCredits=1000;amqpLowCredits=300";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "w2019";
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory() throws JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(URL);
		connectionFactory.setUser(USERNAME);
		connectionFactory.setPassword(PASSWORD);
	
		return connectionFactory;
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() throws JMSException {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(this.connectionFactory());
		factory.setConcurrency("3-10");
		
		return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() throws JMSException {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(this.connectionFactory());
		return jmsTemplate;
	}
	
}

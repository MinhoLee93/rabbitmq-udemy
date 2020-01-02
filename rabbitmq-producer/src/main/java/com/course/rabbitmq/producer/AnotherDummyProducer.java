package com.course.rabbitmq.producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


//@Service
public class AnotherDummyProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendDummy() {
		rabbitTemplate.convertAndSend("x.another-dummy", "", "dummy");
	}

}

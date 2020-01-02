package com.course.rabbitmqproducer.producer;


import com.course.rabbitmqproducer.entity.DummyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnotherDummyProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendDummy() {
		rabbitTemplate.convertAndSend("x.another-dummy", "", "dummy");
	}

}

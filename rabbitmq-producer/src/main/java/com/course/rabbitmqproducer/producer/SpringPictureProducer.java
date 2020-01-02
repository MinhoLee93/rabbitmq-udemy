package com.course.rabbitmqproducer.producer;

import com.course.rabbitmqproducer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class SpringPictureProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ObjectMapper objectMapper  = new ObjectMapper();
	
	public void sendMessage(Picture p){
		String json = null;
		try {
			json = objectMapper.writeValueAsString(p);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		rabbitTemplate.convertAndSend("x.spring.work", p.getType(), json);
	}
	
}

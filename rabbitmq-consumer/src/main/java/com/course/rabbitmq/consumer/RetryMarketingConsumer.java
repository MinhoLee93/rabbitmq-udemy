package com.course.rabbitmq.consumer;

import java.io.IOException;

import lombok.experimental.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.course.rabbitmq.entity.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;

//@Service
public class RetryMarketingConsumer {

	private static final Logger log = LoggerFactory.getLogger(RetryMarketingConsumer.class);
	private ObjectMapper objectMapper;

	public RetryMarketingConsumer() {
		this.objectMapper = new ObjectMapper();
	}

	@RabbitListener(queues = "q.guideline2.marketing.work")
	public void listen(Message message, Channel channel)
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		var e = objectMapper.readValue(message.getBody(), Employee.class);
		log.info("On marketing : " + e);
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}
}
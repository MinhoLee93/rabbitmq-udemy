package com.course.rabbitmqproducer.utility;

import java.time.Duration;
import java.util.Base64;
import java.util.List;

import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RabbitmqProxyService {

	private static final Logger Log = LoggerFactory.getLogger(RabbitmqProxyService.class);

	public List<RabbitmqQueue> getAllQueues() {
		var webClient = WebClient.create("http://15.164.97.2:15672/api/queues");

		return webClient.get().header("Authorization", createBasicAuthHeaders()).retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<RabbitmqQueue>>() {
				}).block(Duration.ofSeconds(10));
	}

	public String createBasicAuthHeaders() {
		// username:password for rabbitmq
		var auth = "daily-mission-admin:minholee93";
		return "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
	}

}

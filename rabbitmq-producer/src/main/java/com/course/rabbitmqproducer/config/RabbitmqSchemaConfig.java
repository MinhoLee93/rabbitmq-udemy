package com.course.rabbitmqproducer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqSchemaConfig {

	@Bean
	public FanoutExchange createFanoutExchange() {
		return new FanoutExchange("x.another-dummy", true, false, null);
	}

	@Bean
	public Queue createQueue() {
		return new Queue("q.another-dummy");
	}

	@Bean
	public Binding createBinding() {
		//return new Binding("q.another-dummy", DestinationType.QUEUE, "x.another-dummy", "", null);
		return BindingBuilder.bind(createQueue()).to(createFanoutExchange());
	}

//	@Bean
//	public Declarables createRabbitmqSchema() {
//		return new Declarables(new FanoutExchange("x.another-dummy", true, false, null), new Queue("q.another-dummy"),
//				new Binding("q.another-dummy", DestinationType.QUEUE, "x.another-dummy", "", null));
//	}

}

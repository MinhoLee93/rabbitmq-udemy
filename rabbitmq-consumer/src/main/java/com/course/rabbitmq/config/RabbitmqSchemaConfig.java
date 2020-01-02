package com.course.rabbitmq.config;

import lombok.experimental.var;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqSchemaConfig {

//	@Bean
//	public FanoutExchange createFanoutExchange() {
//		return new FanoutExchange("x.another-dummy", true, false, null);
//	}
//
//	@Bean
//	public Queue createQueue() {
//		return new Queue("q.another-dummy");
//	}
//
//	@Bean
//	public Binding createBinding() {
//		//return new Binding("q.another-dummy", DestinationType.QUEUE, "x.another-dummy", "", null);
//		return BindingBuilder.bind(createQueue()).to(createFanoutExchange());
//	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());

		return rabbitTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter jsonMessageConverter(){
		return new Jackson2JsonMessageConverter();
	}
//
//	@Bean
//	public RabbitListenerEndpointRegistry registry(){
//		return new RabbitListenerEndpointRegistry();
//	}

//	@Bean
//	public Declarables createRabbitmqSchema() {
//		return new Declarables(new FanoutExchange("x.another-dummy", true, false, null), new Queue("q.another-dummy"),
//				new Binding("q.another-dummy", DestinationType.QUEUE, "x.another-dummy", "", null));
//	}
//
//	@Bean
//	public RabbitListenerContainerFactory<SimpleMessageListenerContainer> prefetchOneContainerFactory(
//			SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory
//	){
//		var factory = new SimpleRabbitListenerContainerFactory();
//		configurer.configure(factory, connectionFactory);
//		factory.setPrefetchCount(1);
//
//		return factory;
//	}


}

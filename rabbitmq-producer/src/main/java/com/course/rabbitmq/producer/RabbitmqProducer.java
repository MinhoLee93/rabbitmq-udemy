package com.course.rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

//@Service
public class RabbitmqProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private Logger log = LoggerFactory.getLogger(RabbitmqProducer.class) ;

    private int i = 0;

    @Scheduled(fixedRate = 500)
    public void sendMessage(){
        i++;
        rabbitTemplate.convertAndSend("q.minho", i);
        log.info("send message " + i);
    }
}

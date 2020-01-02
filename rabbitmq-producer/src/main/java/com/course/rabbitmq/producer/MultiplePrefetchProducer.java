package com.course.rabbitmq.producer;

import com.course.rabbitmq.entity.DummyMessage;
import lombok.experimental.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplePrefetchProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger log = LoggerFactory.getLogger(MultiplePrefetchProducer.class);

    public void simulateTransaction(){
        for(int i=0; i<20000; i++){
            var message =new DummyMessage("transaction + " + i, i);
            rabbitTemplate.convertAndSend("x.transaction", "", message);
        }
    }

    public void simulateScheduler(){
        for(int i=0; i<200; i++){
            var message =new DummyMessage("scheduler + " + i, i);
            rabbitTemplate.convertAndSend("x.scheduler", "", message);
        }
    }
}

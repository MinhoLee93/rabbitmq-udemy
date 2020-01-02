package com.course.rabbitmqconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AnotherDummyConsumer {

    private static final Logger Log = LoggerFactory.getLogger(AnotherDummyConsumer.class);

    @RabbitListener(queues = "q.another-dummy")
    public void listenDummy(String message){
        Log.info(message);
    }
}

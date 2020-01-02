package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class DummyPrefetchConsumer {

    private static final Logger log = LoggerFactory.getLogger(DummyPrefetchConsumer.class);

    @RabbitListener(queues = "q.dummy", concurrency = "2", containerFactory = "prefetchOneContainerFactory")
    public void listenDummy(DummyMessage message){
        log.info("message is {} ", message);
    }
}

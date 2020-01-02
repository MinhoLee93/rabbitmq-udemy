package com.course.rabbitmq.consumer;


import com.course.rabbitmq.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

//@Service
public class PictureImageConsumer {

    private Logger log = LoggerFactory.getLogger(PictureImageConsumer.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.picture.image")
    public void listen(String message){
        try {
            Picture p = objectMapper.readValue(message , Picture.class);
            log.info("Image Picture is {} ", p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

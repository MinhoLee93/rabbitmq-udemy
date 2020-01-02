package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;


//@Service
public class PictureVectorConsumer {

    private Logger log = LoggerFactory.getLogger(PictureVectorConsumer.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.picture.vector")
    public void listen(String message){
        try {
            Picture p = objectMapper.readValue(message , Picture.class);
            log.info("Image Vector is {} ", p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

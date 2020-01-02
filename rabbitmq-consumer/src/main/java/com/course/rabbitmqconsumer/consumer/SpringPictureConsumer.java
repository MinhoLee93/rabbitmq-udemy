package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SpringPictureConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger log = LoggerFactory.getLogger(SpringPictureConsumer.class);

    @RabbitListener(queues = "q.spring.image.work")
    public void listenImage(String message) throws IOException {

        var picture = objectMapper.readValue(message, Picture.class);
        log.info("Consuming image {} ", picture.getName());

        if(picture.getSize()>9000){
            throw  new IOException("Image " + picture.getName() + " size too large : " + picture.getSize());
        }

        log.info("Creating thumnail & publishing image : {} ", picture.getName());
    }

    @RabbitListener(queues = "q.spring.vector.work")
    public void listenVector(String message) throws IOException {

        var picture = objectMapper.readValue(message, Picture.class);
        log.info("Consuming vector {} ", picture.getName());
    }
}

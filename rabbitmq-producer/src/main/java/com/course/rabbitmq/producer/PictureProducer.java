package com.course.rabbitmq.producer;

import com.course.rabbitmq.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class PictureProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(Picture p){

        try {
            String json = objectMapper.writeValueAsString(p);
            rabbitTemplate.convertAndSend("x.picture",p.getType(), json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}

package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

//@Service
public class MyPictureConsumer {

    private Logger log = LoggerFactory.getLogger(MyPictureConsumer.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.mypicture.image")
    public void listen(Message message, Channel channel) throws IOException {

            Picture p = objectMapper.readValue(message.getBody() , Picture.class);

            if(p.getSize()>9000) {
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            }

            log.info("Image Picture is {} ", p);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}

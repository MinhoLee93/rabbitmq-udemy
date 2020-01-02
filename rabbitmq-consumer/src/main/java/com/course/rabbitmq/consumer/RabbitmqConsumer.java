package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;


//@Service
public class RabbitmqConsumer {

    private Logger log = LoggerFactory.getLogger(RabbitmqConsumer.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.employee")
    public void listen(String message){
        try {
            Employee emp = objectMapper.readValue(message , Employee.class);
            log.info("Employee is {} ", emp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

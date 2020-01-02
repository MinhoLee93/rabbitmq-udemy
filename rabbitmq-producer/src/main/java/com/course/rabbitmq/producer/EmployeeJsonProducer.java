package com.course.rabbitmq.producer;

import com.course.rabbitmq.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class EmployeeJsonProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(Employee emp){

        try {
            String json = objectMapper.writeValueAsString(emp);
            rabbitTemplate.convertAndSend("q.employee", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}

package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.LocalDateDeSerializer;
import com.course.rabbitmqconsumer.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;

//@Service
public class EmployeeJsonConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger log = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

    @RabbitListener(queues = "course.employee")
    public void listen(String message){
        Employee emp;
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(LocalDate.class, new LocalDateDeSerializer());
        objectMapper.registerModule(simpleModule);

        try {
            emp = objectMapper.readValue(message, Employee.class);
            log.info("Employee is  {}", emp );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

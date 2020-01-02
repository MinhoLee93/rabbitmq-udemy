package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;


//@Service
public class AccountingConsumer {

    private Logger log = LoggerFactory.getLogger(AccountingConsumer.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.hr.accounting")
    public void listen(String message){
        try {
            Employee emp = objectMapper.readValue(message , Employee.class);
            log.info("On accounting, Employee is {} ", emp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

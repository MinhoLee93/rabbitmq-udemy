package com.course.rabbitmq.consumer;


import com.course.rabbitmq.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.entity.InvoicePaidMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "q.invoice")
public class InvoiceConsumer {

    private static final Logger log = LoggerFactory.getLogger(InvoiceConsumer.class);

    @RabbitHandler
    public void handleInvoiceCreated(InvoiceCreatedMessage message){
        log.info("invoice created : {} ", message);
    }

    @RabbitHandler
    public void handleInvoicePaid(InvoicePaidMessage message){
        log.info("invoice paid : {} ", message);
    }

    @RabbitHandler(isDefault = true)
    public void handleDefault(Object message){
        log.info("invoice paid : {} ", message);
    }
}

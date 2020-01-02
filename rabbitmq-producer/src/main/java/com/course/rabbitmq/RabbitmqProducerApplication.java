package com.course.rabbitmq;


import com.course.rabbitmq.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.entity.InvoicePaidMessage;
import com.course.rabbitmq.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

    @Autowired
    InvoiceProducer rabbitProducer;

    @Override
    public void run(String... args) {
        InvoiceCreatedMessage created = new InvoiceCreatedMessage();
        created.setAmount(11);
        created.setCreatedDate(LocalDate.now());
        created.setCurrency("USD");
        created.setInvoiceNumber("11");
        rabbitProducer.sendInvoiceCreated(created);


        InvoicePaidMessage paid = new InvoicePaidMessage();
        paid.setInvoiceNumber("22");
        paid.setPaidDate(LocalDate.now());
        rabbitProducer.sendInvoicePaid(paid);

    }
}

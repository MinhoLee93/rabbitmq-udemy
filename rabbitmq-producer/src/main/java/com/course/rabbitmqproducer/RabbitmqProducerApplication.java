package com.course.rabbitmqproducer;


import com.course.rabbitmqproducer.entity.DummyMessage;
import com.course.rabbitmqproducer.entity.Picture;
import com.course.rabbitmqproducer.producer.AnotherDummyProducer;
import com.course.rabbitmqproducer.producer.PictureProducer;
import com.course.rabbitmqproducer.producer.SpringPictureProducer;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

    @Autowired
    AnotherDummyProducer rabbitProducer;

    @Override
    public void run(String... args) {
        var message = new DummyMessage("dummy", 1);
        rabbitProducer.sendDummy();
    }
}

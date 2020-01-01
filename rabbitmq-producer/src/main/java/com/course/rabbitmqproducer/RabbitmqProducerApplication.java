package com.course.rabbitmqproducer;

import com.course.rabbitmqproducer.entity.Employee;
import com.course.rabbitmqproducer.entity.Picture;
import com.course.rabbitmqproducer.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


@SpringBootApplication
@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {


    @Autowired
   // private RetryPictureProducer rabbitmqProducer;

    //private final List<String> SOURCES = Arrays.asList("mobile", "web");

    //private final List<String> TYPES = Arrays.asList("jpg", "png", "svg");

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) {
//       for(int i=0; i<1; i++){
//
//           Picture p = new Picture();
//           p.setName("picture " + i);
//           p.setSize(ThreadLocalRandom.current().nextLong(9001,10001));
//           p.setSource(SOURCES.get(i%SOURCES.size()));
//           p.setType(TYPES.get(i%TYPES.size()));
//
//           rabbitmqProducer.sendMessage(p);
//       }
    }
}

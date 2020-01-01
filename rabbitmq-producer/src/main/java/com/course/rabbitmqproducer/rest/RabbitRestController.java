package com.course.rabbitmqproducer.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;


//@RestController
public class RabbitRestController {

    private static final Logger log = LoggerFactory.getLogger(RabbitRestController.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    RabbitTemplate rabbitTemplate;

    public static boolean isValidJson(String string){

        try {
            OBJECT_MAPPER.readTree(string);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    //@PostMapping(path = {"/api/publish/{exchange}/{routingKey}","/api/publish/{exchange}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> publish(@PathVariable(name = "exchange", required = true) String exchange,
                                          @PathVariable(name = "routingKey", required = false) Optional<String> routingKey,
                                          @RequestBody String message){
        log.info("test");

        if(!isValidJson(message)){
            return ResponseEntity.badRequest().body(Boolean.FALSE.toString());
        }

        try {
            rabbitTemplate.convertAndSend(exchange, routingKey.orElse(""), message);
            return ResponseEntity.ok().body(Boolean.TRUE.toString());
        }catch (Exception e){
            log.error("error when publishing {} " , e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }
}

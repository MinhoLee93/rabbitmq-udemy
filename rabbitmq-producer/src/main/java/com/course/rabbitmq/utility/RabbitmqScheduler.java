package com.course.rabbitmq.utility;

import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RabbitmqScheduler {

    private static final Logger log = LoggerFactory.getLogger(RabbitmqScheduler.class);

    @Autowired
    private RabbitmqProxyService rabbitmqProxyService;

    @Scheduled(fixedDelay = 90000)
    public void  sweepDirtyQueues(){

        var dirtyQueues = rabbitmqProxyService.getAllQueues().stream().filter(q-> q.isDirty()).collect(Collectors.toList());
        log.info(String.valueOf(dirtyQueues.size()));

        dirtyQueues.forEach(q-> log.info("Queue {} has {} unporcessd message", q.getName(), q.getMessages() ));

    }
}

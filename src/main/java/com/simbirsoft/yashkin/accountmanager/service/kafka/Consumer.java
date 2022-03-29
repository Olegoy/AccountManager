package com.simbirsoft.yashkin.accountmanager.service.kafka;

import com.simbirsoft.yashkin.accountmanager.constants.Constants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = {Constants.TOPIC, Constants.TOPIC_USERS}, groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message = " + message);
    }

    @KafkaListener(topics = {Constants.TOPIC_PROJECTS}, clientIdPrefix = "AccountClient", groupId = "group_id")
    public void consumeProjectsMessage(String message) {
        System.out.println("Consumed message = " + message);
    }
}

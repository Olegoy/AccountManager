package com.simbirsoft.yashkin.accountmanager.service.kafka;

import com.simbirsoft.yashkin.accountmanager.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        this.kafkaTemplate.send(Constants.TOPIC, message);
        this.kafkaTemplate.send(Constants.TOPIC_USERS, message);
    }

    public void sendProjectsMessage(String message) {
        this.kafkaTemplate.send(Constants.TOPIC_PROJECTS, "Account", message);
    }

}

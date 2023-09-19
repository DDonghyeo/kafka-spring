package com.kafka.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    //----------- Producer -----------
    public void sendMessage(String message) {
        log.info("[Producer] Message Send : " + message);
        this.kafkaTemplate.send("topic_1", message);
    }


    //----------- Consumer -----------
    @KafkaListener(topics = "topic_1", groupId = "myGroup")
    public void consumeMyopic1(@Payload String message, ConsumerRecordMetadata metadata) {
        log.info("[Consumer] Message Received : " + message);
        log.info("[Consumer] Partition : " + metadata.partition());
    }
}

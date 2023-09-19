package com.kafka.kafka.controller;

import com.kafka.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("")
    public String sendMessage(@RequestParam("message") String message) {
        kafkaService.sendMessage(message);
        return "Send Success!";
    }
}

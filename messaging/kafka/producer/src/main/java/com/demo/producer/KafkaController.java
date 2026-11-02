package com.demo.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api")
//public class KafkaController {
//
//    private KafkaTemplate<String , RiderLocation> kafkaTemplate;
//
//    public KafkaController(KafkaTemplate<String , RiderLocation> kafkaTemplate){
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @GetMapping("/send")
//    public String sendMessage(@RequestParam String message){
//        RiderLocation location = new RiderLocation("rider123" , 27.77 , 71.11);
//        kafkaTemplate.send("my-new-topic" , location);
//        return "Message sent : " + location.getRiderId();
//    }
//}

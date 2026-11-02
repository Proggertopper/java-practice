package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
//public class KafkaConsumer {
//
//    @KafkaListener(topics = "my-topic" , groupId = "my-new-group")
//    public void listen(String message){
//        System.out.println("Received message " + message);
//    }
//
//    @KafkaListener(topics = "my-new-topic" , groupId = "my-new-group-rider")
//    public void listenRiderLocation(RiderLocation location){
//        System.out.println("Received Location : " + location.getRiderId() + " : "
//        + location.getLatitude() + " : " + location.getLongitude());
//    }
//}

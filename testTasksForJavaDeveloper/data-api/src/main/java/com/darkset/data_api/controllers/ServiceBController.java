package com.darkset.data_api.controllers;

import com.darkset.data_api.dto.TransformResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

    @Value("${X-Internal-Token}")
    private String tokenServiceB;

    @PostMapping("/api/transform")
    public ResponseEntity<TransformResponse> transform(@RequestBody String text , @RequestHeader("X-Internal-Token") String token){
        if(!tokenServiceB.equals(token) || token.isEmpty()){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        String result = text.toUpperCase().concat(" transformed text");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new TransformResponse(result));
    }
}

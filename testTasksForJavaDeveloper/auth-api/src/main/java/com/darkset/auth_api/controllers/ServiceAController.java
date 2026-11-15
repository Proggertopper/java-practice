package com.darkset.auth_api.controllers;

import com.darkset.auth_api.dto.ProcessRequest;
import com.darkset.auth_api.dto.TransformResponse;
import com.darkset.auth_api.dto.UserRequest;
import com.darkset.auth_api.models.ProcessingLog;
import com.darkset.auth_api.models.User;
import com.darkset.auth_api.repos.ProcessingLogRepository;
import com.darkset.auth_api.repos.UsersRepository;
import com.darkset.auth_api.security.JwtService;
import com.darkset.auth_api.services.ServiceAService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ServiceAController {

    private final ServiceAService serviceAService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RestClient restClient = RestClient.create();
    private final ProcessingLogRepository processingLogRepository;
    private final UsersRepository usersRepository;

    @Value("${X-Internal-Token}")
    private String tokenServiceA;


    @PostMapping("/auth/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRequest request){
        return new ResponseEntity<>(serviceAService.registerUser(request.email() , request.password()) , HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> loginUser(@RequestBody UserRequest request){
        User user = serviceAService.loginUser(request.email() , request.password());
        String token = null;
        if(passwordEncoder.matches(request.password(), user.getPasswordHash())){
                token = jwtService.generateToken(request.email());
                return new ResponseEntity<>(token , HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/process")
    public ResponseEntity<String> process(@RequestBody ProcessRequest request, @RequestHeader("Authorization") String auth){
        if(auth  == null || !auth.startsWith("Bearer ")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        String token = auth.split(" ")[1];
        if (!jwtService.isTokenValid(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        String email = jwtService.extractEmail(token);
        User user = usersRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        TransformResponse response = restClient.post().uri("http://data-api:8081/api/transform").header("X-Internal-Token" , tokenServiceA )
                .body(request).retrieve().body(TransformResponse.class);
        ProcessingLog log = new ProcessingLog();
        log.setUser(user);
        log.setInputText(request.text());
        log.setOutputText(response.result());
        log.setCreatedAt(LocalDateTime.now());
        processingLogRepository.save(log);
        return new ResponseEntity<>(response.result() , HttpStatus.OK);
    }
}

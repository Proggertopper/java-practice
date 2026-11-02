package com.example.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Service2Client {
    private final RestTemplate rest;
    private final OAuth2AuthorizedClientManager manager;

    @Value("${spring.service2.uri}")
    private String service2Url;

    public Service2Client(RestTemplate rest, OAuth2AuthorizedClientManager manager) {
        this.rest = rest;
        this.manager = manager;
    }

    public String fetchData(){
//        var authRequest = OAuth2AuthorizeRequest
//                .withClientRegistrationId("keycloak-client")
//                .principal("machine")
//                .build();
//
//        var client = manager.authorize(authRequest);
//
//        var token = client.getAccessToken().getTokenValue();
//
//        var httpHeaders = new HttpHeaders();
//        httpHeaders.setBearerAuth(token);
//
//        var resp = rest.exchange(
//                service2Url + "/data", HttpMethod.GET , new HttpEntity<>(httpHeaders) , String.class
//        );
//
//        return resp.getBody();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String incomingToken = null;
         if(auth instanceof JwtAuthenticationToken jwtAuthenticationToken){
             incomingToken = jwtAuthenticationToken.getToken().getTokenValue();
         }
        System.out.println("TOKEN VALUE " + incomingToken);
        var httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(incomingToken);

        var resp = rest.exchange(
                service2Url + "/data", HttpMethod.GET , new HttpEntity<>(httpHeaders) , String.class
        );

        return resp.getBody();
    }
}

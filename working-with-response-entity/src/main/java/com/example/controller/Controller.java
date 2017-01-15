package com.example.controller;

import com.example.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    
    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/github/{username}")
    ResponseEntity getUser(@PathVariable String username) {    
        ResponseEntity entity = restTemplate
                .getForEntity("https://api.github.com/users/{username}",
                        User.class, username);

        HttpHeaders responseHeaders = new HttpHeaders();

        //Filter Content-Length header and add other to responseHeaders
        entity.getHeaders().entrySet()
                .forEach(
                        header -> {
                            if (!header.getKey().equals(HttpHeaders.CONTENT_LENGTH)) {
                                header.getValue().forEach(
                                        headerValue ->
                                                responseHeaders.set(header.getKey(), headerValue)
                                );
                            }
                        }
                );
        return new ResponseEntity(entity.getBody(), responseHeaders, HttpStatus.OK);
    }
}

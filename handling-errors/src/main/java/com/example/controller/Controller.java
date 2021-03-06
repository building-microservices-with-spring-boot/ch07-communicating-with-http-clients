package com.example.controller;

import com.example.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
	
	RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/github/{username}")
    User getUser(@PathVariable String username) {
        User user = restTemplate.getForObject("https://api.github.com/users/{username}", User.class, username);
        return user;
    }
    
}




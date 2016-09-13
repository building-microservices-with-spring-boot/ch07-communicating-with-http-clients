package com.example.controller;

import com.config.RecoEngineRibbonConfig;
import com.example.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name = "reco-engine", configuration = RecoEngineRibbonConfig.class)
public class Controller {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/my-recommendations")
    public Recommendation get() {
        return this.restTemplate.getForObject("http://reco-engine/recommendations", Recommendation.class);
    }

}

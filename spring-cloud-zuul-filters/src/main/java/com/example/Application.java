package com.example;

import com.example.filters.post.ResponseHeaderFilter;
import com.example.filters.pre.DebugFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public DebugFilter debugFilter() {
        return new DebugFilter();
    }

    @Bean
    public ResponseHeaderFilter addHeaderFilter() {
        return new ResponseHeaderFilter();
    }
}

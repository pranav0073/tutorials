package com.codefix.gitbuddy.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public RestTemplate getRestTemplate(){
       RestTemplate restTemplate =  new RestTemplate();
       return restTemplate;
    }
}

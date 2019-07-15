package com.weather.sync_weather_data.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Bean
    public RestTemplate getRestTemplate(){
        return restTemplateBuilder.build();
    }
}

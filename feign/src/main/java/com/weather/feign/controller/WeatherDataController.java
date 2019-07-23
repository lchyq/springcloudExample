package com.weather.feign.controller;

import com.weather.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherDataController {
    @Autowired
    private FeignService feignService;
    @GetMapping("/weatherData")
    public String getWeatherData(){
        String data = feignService.getWeatherData();
        return data;
    }

}

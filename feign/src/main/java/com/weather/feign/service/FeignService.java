package com.weather.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("city-weather-data")
public interface FeignService {
    @GetMapping("/weather/citydata")
    String getWeatherData();
}

package com.weathwe.weather_report.service;

import com.weathwe.weather_report.Response.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("weather-data")
public interface WeatherDataFeignService {
    @GetMapping("/weather/cityId/{cityid}")
    WeatherResponse getWeatherData(@PathVariable("cityid") String cityId);
}

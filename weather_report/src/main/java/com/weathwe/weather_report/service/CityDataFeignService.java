package com.weathwe.weather_report.service;

import com.weathwe.weather_report.bean.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("city-weather-data")
public interface CityDataFeignService {
    @GetMapping("/weather/citydata")
    List<City> getCityList();
}

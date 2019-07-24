package com.weather.sync_weather_data.service;

import com.weather.sync_weather_data.bean.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("city-weather-data")
public interface CityWeatherDatafeignService {
    @GetMapping("/weather/citydata")
    public List<City> getWeatehrData();
}

package com.weather.city_weather_data.controller;

import com.weather.city_weather_data.bean.City;
import com.weather.city_weather_data.serviceImpl.TransXmltoBeanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class CityWeatherDataController {
    @Autowired
    private TransXmltoBeanImpl transXmltoBean;
    @GetMapping("/citydata")
    public List<City> getCityWeatherList(){
        return transXmltoBean.transferXml();
    }
}

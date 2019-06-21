package com.weather.basic.weather_basic.controller;

import com.weather.basic.weather_basic.Response.WeatherResponse;
import com.weather.basic.weather_basic.Service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;

    /**
     * 根据城市id获取预报信息
     * @param cityId
     * @return
     */
    @RequestMapping("/cityId/{cityid}")
    public WeatherResponse getWeatherDataByCityId(@PathVariable("cityid") String cityId){
        return weatherDataService.getWeatherDataById(cityId);
    }

    /**
     * 根据城市名称获取预报信息
     * @param cityName
     * @return
     */
    @RequestMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherDataByCityName(@PathVariable("cityName") String cityName){
        return weatherDataService.getWeatherDataByName(cityName);
    }
}

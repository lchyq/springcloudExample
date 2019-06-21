package com.weather.basic.weather_basic.Service;

import com.weather.basic.weather_basic.Response.WeatherResponse;

/**
 * 天气数据接口服务
 */
public interface WeatherDataService {
    /**
     * 根据城市的id获取天气信息
     */
     WeatherResponse getWeatherDataById(String wId);

    /**
     * 根据天气名称获取天气信息
     */
    WeatherResponse getWeatherDataByName(String wName);
}

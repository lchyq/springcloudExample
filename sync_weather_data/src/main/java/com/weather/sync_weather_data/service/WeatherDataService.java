package com.weather.sync_weather_data.service;
/**
 * 天气数据接口服务
 */
public interface WeatherDataService {
    /**
     * 同步天气信息服务
     */
    void syncWeatherData(String wId);
}

package com.weathwe.weather_report.service;
import com.weathwe.weather_report.bean.Weather;

/**
 * 天气预报服务
 */
public interface WeatherReportService {
    Weather getWeatherReportByCityId(String cityId);
}

package com.weather.basic.weather_basic.Service;

import com.weather.basic.weather_basic.PreVo.Weather;

/**
 * 天气预报服务
 */
public interface WeatherReportService {
    Weather getWeatherReportByCityId(String cityId);
}

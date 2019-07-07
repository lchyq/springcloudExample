package com.weather.basic.weather_basic.ServiceImpl;

import com.weather.basic.weather_basic.PreVo.Weather;
import com.weather.basic.weather_basic.Response.WeatherResponse;
import com.weather.basic.weather_basic.Service.WeatherDataService;
import com.weather.basic.weather_basic.Service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataService weatherDataService;
    @Override
    public Weather getWeatherReportByCityId(String cityId) {
        WeatherResponse weatherResponse = weatherDataService.getWeatherDataById(cityId);
        return weatherResponse.getData();
    }
}

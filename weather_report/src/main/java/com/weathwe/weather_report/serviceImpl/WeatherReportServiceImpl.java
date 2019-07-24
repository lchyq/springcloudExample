package com.weathwe.weather_report.serviceImpl;

import com.weathwe.weather_report.Response.WeatherResponse;
import com.weathwe.weather_report.bean.Weather;
import com.weathwe.weather_report.service.WeatherDataFeignService;
import com.weathwe.weather_report.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    //todo 调用天气数据微服务接口
    @Autowired
    private WeatherDataFeignService weatherDataFeignService;
    @Override
    public Weather getWeatherReportByCityId(String cityId) {
        //todo 调用天气数据微服务接口
        WeatherResponse weatherResponse = weatherDataFeignService.getWeatherData(cityId);
        return weatherResponse.getData();
    }
}

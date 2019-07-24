package com.weather.sync_weather_data.SyncJob;

import com.netflix.discovery.converters.Auto;
import com.weather.sync_weather_data.bean.City;
import com.weather.sync_weather_data.service.CityWeatherDatafeignService;
import com.weather.sync_weather_data.service.WeatherDataService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气信息同步任务
 */
public class WeatherSyncJob extends QuartzJobBean {
    private Logger logger = LoggerFactory.getLogger(WeatherSyncJob.class);
    @Autowired
    private WeatherDataService weatherDataService;
    @Autowired
    private CityWeatherDatafeignService cityWeatherDatafeignService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.error("weatherDataSync start");
        //todo 从城市列表微服务中获取天气列表
        List<City> cities = cityWeatherDatafeignService.getWeatehrData();
        for(City city1 : cities){
            logger.error("cityId:"+city1.getCityId());
            weatherDataService.syncWeatherData(city1.getCityId());
        }
        logger.error("同步结束");
    }
}

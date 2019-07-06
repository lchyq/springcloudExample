package com.weather.basic.weather_basic.WeatherQuartzJob;

import com.weather.basic.weather_basic.PreVo.City;
import com.weather.basic.weather_basic.Service.CityDataService;
import com.weather.basic.weather_basic.Service.WeatherDataService;
import com.weather.basic.weather_basic.ServiceImpl.CityDataServiceImpl;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * 定时获取天气信息的job类
 */
public class WeatherSyncJob extends QuartzJobBean {
    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;
    public static final Logger LOGGER = LoggerFactory.getLogger(WeatherSyncJob.class);
    //重写该方法实现定时逻辑
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.error("weather sync job start");
        List<City> list = null;
        //首先获取所有的城市id
        try{
             list = cityDataService.readCityData();
        }catch (Exception e){
            LOGGER.error("exception!",e);
        }
        //遍历城市id，将数据保存在redis中
        for(City city : list){
            LOGGER.error("cityId : "+ city.getCityId());
            weatherDataService.syncWeatherData(city.getCityId());
        }
        LOGGER.error("weather sync job end");
    }
}

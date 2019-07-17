package com.weather.weather_data.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weather_data.EnumUtil.ResponseStatus;
import com.weather.weather_data.Response.WeatherResponse;
import com.weather.weather_data.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;


@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_DATA_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    @Autowired
    private RestTemplate restTemplate;
    //redisTemplate对String类型数据的封装
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public static final Integer REDIS_EXPIRE = 10;
    //使用log4j来记录日志
    public static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    @Override
    public WeatherResponse getWeatherDataById(String wId) {
        WeatherResponse weatherResponse = new WeatherResponse();
        if(isNull(wId)){
            weatherResponse.setData(null);
            weatherResponse.setStatus(ResponseStatus.fAIL.getCode());
            weatherResponse.setDesc(ResponseStatus.fAIL.getDesc());
            return weatherResponse;
        }
        String uri = WEATHER_DATA_URI + "citykey=" +  wId;

        return getWeatherData(uri,weatherResponse);
    }

    @Override
    public WeatherResponse getWeatherDataByName(String wName) {
        WeatherResponse weatherResponse = new WeatherResponse();
        if(isNull(wName)){
            weatherResponse.setData(null);
            weatherResponse.setStatus(ResponseStatus.fAIL.getCode());
            weatherResponse.setDesc(ResponseStatus.fAIL.getDesc());
            return weatherResponse;
        }
        String uri = WEATHER_DATA_URI + "city=" +  wName;

        return getWeatherData(uri,weatherResponse);
    }

    private WeatherResponse getWeatherData(String uri,WeatherResponse weatherResponse){
        //是否先查缓存，若缓存不存在通过httpclient调用第三方信息
        String key = uri;
        String jsonData = null;
        ObjectMapper objectMapper = new ObjectMapper();
        //用来操作key，value数据的数据结构;
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(key)){
            logger.error("redis 中有数据");
            jsonData = ops.get(key);
        }else{
            logger.error("数据查询失败");
        }
        try {
            weatherResponse = objectMapper.readValue(jsonData,weatherResponse.getClass());
        } catch (IOException e) {
            logger.error("数据查询失败",e);
        }
        return weatherResponse;
    }


    private boolean isNull(String thing){
        if(thing == null)
            return true;
        return false;
    }
}

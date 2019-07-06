package com.weather.basic.weather_basic.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.basic.weather_basic.EnumUtil.ResponseStatus;
import com.weather.basic.weather_basic.Response.WeatherResponse;
import com.weather.basic.weather_basic.Service.WeatherDataService;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

    @Override
    public void syncWeatherData(String wId) {
        String uri = WEATHER_DATA_URI + "citykey=" +  wId;
        saveDataToRedis(uri);
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
        }else {
            //使用httpClint来获取天气信息
            logger.error("redis 中没有数据");
            ResponseEntity<String> responseEntity =  restTemplate.getForEntity(uri,String.class);
            if(responseEntity.getStatusCodeValue() == 200){
                jsonData = responseEntity.getBody();
            }
            //将三方数据缓存到redis中,缓存时间为10s
            ops.set(key,jsonData,REDIS_EXPIRE, TimeUnit.SECONDS);
        }
        try {
            weatherResponse = objectMapper.readValue(jsonData,weatherResponse.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }


    private boolean isNull(String thing){
        if(thing == null)
            return true;
        return false;
    }
    private void saveDataToRedis(String uri){
        String jsonData = null;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri,String.class);
        if(responseEntity.getStatusCodeValue() == 200){
            jsonData = responseEntity.getBody();
        }
        //将数据保存在redis中
        stringRedisTemplate.opsForValue().set(uri,jsonData,30,TimeUnit.MINUTES);
    }
}

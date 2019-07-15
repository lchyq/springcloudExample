package com.weather.sync_weather_data.serviceImpl;

import com.weather.sync_weather_data.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_DATA_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void syncWeatherData(String wId) {
        String uri = WEATHER_DATA_URI + "citykey=" +  wId;
        saveDataToRedis(uri);
    }
    private void saveDataToRedis(String uri){
        String weatherData = null;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri,String.class);
        if(responseEntity.getStatusCodeValue() == 200){
            weatherData = responseEntity.getBody();
        }
        //存入redis
        stringRedisTemplate.opsForValue().set(uri,weatherData,1800, TimeUnit.SECONDS);
    }
}

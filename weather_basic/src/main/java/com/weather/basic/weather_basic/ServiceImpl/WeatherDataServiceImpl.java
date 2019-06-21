package com.weather.basic.weather_basic.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.basic.weather_basic.EnumUtil.ResponseStatus;
import com.weather.basic.weather_basic.Response.WeatherResponse;
import com.weather.basic.weather_basic.Service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_DATA_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    @Autowired
    private RestTemplate restTemplate;
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
        //使用httpClint来获取天气信息
        ResponseEntity<String> responseEntity =  restTemplate.getForEntity(uri,String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = null;
        if(responseEntity.getStatusCodeValue() == 200){
            jsonData = responseEntity.getBody();
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
}

package com.weather.city_weather_data.service;

import com.weather.city_weather_data.bean.City;
import com.weather.city_weather_data.bean.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 解析xml文件
 */
public interface TransXmltoBean {
    /**
     * 将xml文件解析为对应的bean对象
     */
     List<City> transferXml();
}

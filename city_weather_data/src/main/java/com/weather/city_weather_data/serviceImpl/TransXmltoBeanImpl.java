package com.weather.city_weather_data.serviceImpl;

import com.weather.city_weather_data.bean.City;
import com.weather.city_weather_data.bean.CityList;
import com.weather.city_weather_data.service.TransXmltoBean;
import com.weather.city_weather_data.util.XmlToBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
@Service
public class TransXmltoBeanImpl implements TransXmltoBean {
    private Logger logger = LoggerFactory.getLogger(TransXmltoBeanImpl.class);
    @Override
    public List<City> transferXml() {
        Resource resource = new ClassPathResource("city.xml");
        BufferedReader br = null;
        String data = null;
        StringBuilder stringBuilder = null;
        try {
            br = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
            stringBuilder = new StringBuilder();
            while ((data = br.readLine()) != null){
                stringBuilder.append(data);
            }
        } catch (IOException e) {
            logger.error("解析xml数据失败",e);
        }finally {
            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error("流关闭出现异常",e);
                }
            }
        }
        //将解析出的数据转化为bean对象
        CityList cities = XmlToBeanUtil.xmlToBean(CityList.class,stringBuilder.toString()
        );
        return cities.getList();
    }
}

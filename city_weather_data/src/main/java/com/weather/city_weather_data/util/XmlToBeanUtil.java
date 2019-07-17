package com.weather.city_weather_data.util;

import com.weather.city_weather_data.bean.City;
import com.weather.city_weather_data.bean.CityList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

public class XmlToBeanUtil {
    private static Logger logger = LoggerFactory.getLogger(XmlToBeanUtil.class);
    public static CityList xmlToBean(Class<?> clazz, String jsonData){
        //读取数据
        StringReader stringReader = new StringReader(jsonData);
        CityList list = null;
        //创建JAXB解组
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            list = (CityList)unmarshaller.unmarshal(stringReader);
        } catch (JAXBException e) {
            logger.error("创建解组失败",e);
        }
        return list;
    }
}

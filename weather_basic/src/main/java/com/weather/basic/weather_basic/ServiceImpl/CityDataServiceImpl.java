package com.weather.basic.weather_basic.ServiceImpl;

import com.weather.basic.weather_basic.PreVo.City;
import com.weather.basic.weather_basic.PreVo.CityList;
import com.weather.basic.weather_basic.Service.CityDataService;
import com.weather.basic.weather_basic.Util.XmlToObj;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> readCityData() throws IOException, JAXBException {
        //获取类路径下city.xml文件
        Resource resource =  new ClassPathResource("city.xml");
        //读取数据流，并转化为二进制流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }
        //将数据流转化为obj对象
        CityList cityList = (CityList) XmlToObj.xmlToObjUtil(CityList.class,stringBuilder.toString());
        return cityList.getList();
    }
}

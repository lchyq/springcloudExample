package com.weather.basic.weather_basic.Service;

import com.weather.basic.weather_basic.PreVo.City;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface CityDataService {
     List<City> readCityData() throws IOException, JAXBException;
}

package com.weather.basic.weather_basic.controller;

import com.weather.basic.weather_basic.Service.CityDataService;
import com.weather.basic.weather_basic.Service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping("/report")
public class WeatherReportController {
    @Autowired
    private WeatherReportService weatherReportService;
    @Autowired
    private CityDataService cityDataService;
    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws IOException, JAXBException {
        //添加天气预报相关的信息
        model.addAttribute("title","城市天气预报");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",cityDataService.readCityData());
        model.addAttribute("report",weatherReportService.getWeatherReportByCityId(cityId));
        //设置视图的名称，设置model的名称
        return new ModelAndView("weather/report","reportModel",model);
    }
}

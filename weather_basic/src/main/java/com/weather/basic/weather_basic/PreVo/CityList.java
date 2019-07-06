package com.weather.basic.weather_basic.PreVo;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 用来承载xml城市列表数据
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
    @XmlElement(name = "d")
    private List<City> list;

    public List<City> getList() {
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }
}

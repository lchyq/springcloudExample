package com.weather.basic.weather_basic.PreVo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 同来承载xml城市数据
 */
@XmlRootElement(name = "d")
@XmlAccessorType(value = XmlAccessType.FIELD) //根据字段映射
public class City {
    //城市名称
    @XmlAttribute(name = "d2")
    private String cityName;
    //城市编码
    @XmlAttribute(name = "d3")
    private String cityCode;
    //所属省份
    @XmlAttribute(name = "d4")
    private String province;
    //城市id
    @XmlAttribute(name = "d1")
    private String cityId;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}

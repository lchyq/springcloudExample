package com.weathwe.weather_report.Response;

import com.weathwe.weather_report.bean.Weather;

import java.io.Serializable;

public class WeatherResponse implements Serializable {

    private Weather data;
    private Integer status;
    private String desc;

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "data=" + data +
                ", status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}

package com.weather.weather_data.bean;

import java.io.Serializable;

/**
 * 天气预报vo
 * {"date":"21日星期五","high":"高温 32℃","fengli":"
 <![CDATA[<3级]]>","low":"低温 29℃","fengxiang":"无持续风向","type":"阵雨"}
 */
public class Forecast implements Serializable {
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "date='" + date + '\'' +
                ", high='" + high + '\'' +
                ", fengli='" + fengli + '\'' +
                ", low='" + low + '\'' +
                ", fengxiang='" + fengxiang + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

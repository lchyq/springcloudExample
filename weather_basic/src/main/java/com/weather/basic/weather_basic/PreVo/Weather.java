package com.weather.basic.weather_basic.PreVo;
import java.io.Serializable;
import java.util.List;

/**
 * 天气vo
 * {"data":{"yesterday":{"date":"20日星期四","high":"高温 32℃","fx":"无持续风向","low":"低温 27℃","fl":"
 <![CDATA[<3级]]>","type":"多云"},
 "city":"深圳",
 "forecast":[{"date":"21日星期五","high":"高温 32℃","fengli":"
 <![CDATA[<3级]]>","low":"低温 29℃","fengxiang":"无持续风向","type":"阵雨"},

 {"date":"22日星期六","high":"高温 32℃","fengli":"
 <![CDATA[<3级]]>","low":"低温 27℃","fengxiang":"无持续风向","type":"雷阵雨"},

 {"date":"23日星期天","high":"高温 31℃","fengli":"
 <![CDATA[<3级]]>","low":"低温 27℃","fengxiang":"无持续风向","type":"雷阵雨"},

 {"date":"24日星期一","high":"高温 31℃","fengli":"
 <![CDATA[<3级]]>","low":"低温 26℃","fengxiang":"无持续风向","type":"雷阵雨"},

 {"date":"25日星期二","high":"高温 30℃","fengli":"
 <![CDATA[<3级]]>","low":"低温 27℃","fengxiang":"无持续风向","type":"雷阵雨"}],

 "ganmao":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。",
 "wendu":"31"},"status":1000,"desc":"OK"}
 */
public class Weather implements Serializable {
    private Yesterday yesterday;
    private String ganmao;
    private String wendu;
    private String aqi;
    private String city;
    private List<Forecast> forecast;

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmo) {
        this.ganmao = ganmo;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForcast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "yesterday=" + yesterday +
                ", ganmao='" + ganmao + '\'' +
                ", wendu='" + wendu + '\'' +
                ", aqi='" + aqi + '\'' +
                ", city='" + city + '\'' +
                ", forecast=" + forecast +
                '}';
    }
}

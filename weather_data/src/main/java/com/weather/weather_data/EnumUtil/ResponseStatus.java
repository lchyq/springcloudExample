package com.weather.weather_data.EnumUtil;

/**
 * 响应码枚举
 */
public enum ResponseStatus {
    Success(200,"成功"),
    fAIL(500,"失败");

    private Integer code;
    private String desc;

    ResponseStatus(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ResponseStatus(){}
}

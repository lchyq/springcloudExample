package com.weather.basic.weather_basic.WeatherQuartzJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时获取天气信息的job类
 */
public class WeatherSyncJob extends QuartzJobBean {
    public static final Logger LOGGER = LoggerFactory.getLogger(WeatherSyncJob.class);
    //重写该方法实现定时逻辑
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.error("weather sync job");
    }
}

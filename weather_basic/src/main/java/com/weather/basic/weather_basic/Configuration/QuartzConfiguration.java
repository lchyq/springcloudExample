package com.weather.basic.weather_basic.Configuration;
import com.weather.basic.weather_basic.WeatherQuartzJob.WeatherSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * quartz的配置类
 */
@Configuration
public class QuartzConfiguration {
    //jobDetail job详情
    @Bean
    public JobDetail weatherJobDetail(){
        /**
         * 创建一个WeatherSyncJob类型的job
         * 名称为weatherJobDetail
         * 使用过一次之后不销毁
         */
        return JobBuilder.newJob(WeatherSyncJob.class).withIdentity("weatherJobDetail")
                .storeDurably().build();
    }
    //Trigger 触发器
    @Bean
    public Trigger weatherTrigger(){
        //创建一个周期器
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1800).repeatForever();
        //触发器根据周期器来周期的执行任务
        return TriggerBuilder.newTrigger().forJob(weatherJobDetail()).withIdentity("weatherTrigger")
                .withSchedule(simpleScheduleBuilder)
                .build();
    }
}

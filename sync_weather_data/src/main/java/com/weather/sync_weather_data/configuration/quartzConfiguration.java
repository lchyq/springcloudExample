package com.weather.sync_weather_data.configuration;

import com.weather.sync_weather_data.SyncJob.WeatherSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class quartzConfiguration {
    //实例化jobDetail，来描述job的信息
    @Bean
    public JobDetail weatherJodDetail(){
       return JobBuilder.newJob(WeatherSyncJob.class).storeDurably()
               .withIdentity("WeatherSyncJob").build();
    }
    //实例化Trigger，用来定时执行job
    @Bean
    public Trigger WeatherTrigger(){
        //初始化schedule
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .repeatForever().withIntervalInSeconds(1800);
        return TriggerBuilder.newTrigger().forJob(weatherJodDetail())
                .withSchedule(simpleScheduleBuilder).withIdentity("WeatherTrigger").build();
    }
}

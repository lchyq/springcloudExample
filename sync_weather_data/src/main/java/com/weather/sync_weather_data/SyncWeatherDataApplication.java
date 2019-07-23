package com.weather.sync_weather_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SyncWeatherDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyncWeatherDataApplication.class, args);
	}

}

package com.wheather.joker.rp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HowsTheWeatherProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowsTheWeatherProducerApplication.class, args);
	}

}

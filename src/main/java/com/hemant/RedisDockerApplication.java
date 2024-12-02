package com.hemant;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@RequiredArgsConstructor
public class RedisDockerApplication  {


	public static void main(String[] args) {
		SpringApplication.run(RedisDockerApplication.class, args);
	}


}

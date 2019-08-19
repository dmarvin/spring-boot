package com.djm.springbootstart;

import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableRunTime
public class SpringBootStartApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootStartApplication.class);
		builder.run();
	}

}

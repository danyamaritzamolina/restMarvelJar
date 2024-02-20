package com.open.pay.restMarvelJar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
@ComponentScan
public class RestMarvelJarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMarvelJarApplication.class, args);
	}

}

package com.DistrubutedComputing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.DistrubutedComputing")
@SpringBootApplication
@ImportResource("classpath:com/DistrubutedComputing/spring-servlet.xml")
public class ApplicationConfig extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}
	
	
	
}

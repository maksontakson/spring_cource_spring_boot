package com.example.spring_cource_spring_boot;

import com.example.spring_cource_spring_boot.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringCourceSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCourceSpringBootApplication.class, args);
	}

}

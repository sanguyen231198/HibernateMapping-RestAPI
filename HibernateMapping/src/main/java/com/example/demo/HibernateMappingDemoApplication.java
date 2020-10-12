package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.controller.BaseController;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
public class HibernateMappingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateMappingDemoApplication.class, args);
	}

}

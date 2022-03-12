package com.chegg.schoolsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SchoolsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolsystemApplication.class, args);
	}

}

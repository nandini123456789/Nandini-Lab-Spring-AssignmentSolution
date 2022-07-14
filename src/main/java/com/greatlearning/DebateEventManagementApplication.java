package com.greatlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
//@ComponentScan(basePackages = "com.greatlearning.controller," + "com.greatlearning.service")
//@ComponentScan(basePackages = "com.greatlearning" )
public class DebateEventManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebateEventManagementApplication.class, args);
	}

}

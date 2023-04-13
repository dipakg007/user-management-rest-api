package com.crudrest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation", 
				description = "End to End production ready RESTfull API project", 
				version = "v1.0", 
				contact = @Contact(name = "Dipak Gupta", email = "dg9877626@gmail.com", url="https://start.spring.io/"), 
				license = @License(name = "Apache 2.0", url = "https://start.spring.io/")

), externalDocs = @ExternalDocumentation(description = "Spring boot user management documentation", url = "https://start.spring.io/"))
public class SpringbootRestfullWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}

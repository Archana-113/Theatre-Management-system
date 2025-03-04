package com.project.Theatre_Management_System.util;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Theatre Management System")
                        .description("Theatre_Management_System is a project for managing theatre bookings, "
                                + "show schedules, and ticket reservations. "
                                + "This system allows users to browse movies, book tickets, and manage seat selections. "
                                + "It helps streamline the booking process and maintain show history.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Qspiders Team")
                                .email("archana.abramaina113@gmail.com"))
                        .license(new License().name("License").url("#")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("public")
                .packagesToScan("com.project.Theatre_Management_System").build();
    }
}


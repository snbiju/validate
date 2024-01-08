package com.example.validate.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("Validate example")
            .description("Spring Rest Validate")
            .version("v0.0.2")
            .contact(getContactDetails())
            .license(getLicenseDetails()));
    }

    private Contact getContactDetails() {
        return new Contact().name("Biju Pillai")
            .email("snbiju@gmail.com")
            .url("");
    }

    private License getLicenseDetails() {
        return new License().name("GNU General Public License v3.0")
            .url("");
    }
}
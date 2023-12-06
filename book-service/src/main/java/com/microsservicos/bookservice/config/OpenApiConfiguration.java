package com.microsservicos.bookservice.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = @Info(title = "Book Service API", version = "v1", description = "Documentation of Book Service API"))
public class OpenApiConfiguration {

	@Bean
	public OpenAPI customOpenApi() {

		return new OpenAPI().components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info().title("Book Service API")
						.description("Documentation of Book Service API")
						.version("v1.0")
						.contact(new Contact()
								.name("Bruno")
								.url("https://meu_microsservico.com")
								.email("brunoclaumari@gmail.com"))
						.termsOfService("TOC")
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")));
	}

}

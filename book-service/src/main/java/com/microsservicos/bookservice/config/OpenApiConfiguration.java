package com.microsservicos.bookservice.config;

//import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.servers.Server;

//@OpenAPIDefinition(info = @Info(title = "Book Service API", version = "v1", description = "Documentation of Book Service API"))
@Configuration
public class OpenApiConfiguration {

	@Bean
	public OpenAPI customOpenApi() {
//		Server devServer = new Server();
//		devServer.setUrl("http://localhost:8100");
//		devServer.setDescription("Server URL in Development environment");
//
////		Server prodServer = new Server();
////		prodServer.setUrl(prodUrl);
////		prodServer.setDescription("Server URL in Production environment");
//
//		Contact contact = new Contact();
//		contact.setEmail("brunoclaumari@gmail.com");
//		contact.setName("Bruno de Sousa Silva");
//		contact.setUrl("https://www.brunosousadev.com");
//
//		License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
//
//		Info info = new Info()
//				.title("API registrer for users with account").version("1.0")
//				.contact(contact)
//				.description("Documentation of Book Service API")
//				.termsOfService("https://www.sitedobruno.com/terms").license(mitLicense);
//
//		return new OpenAPI().info(info).servers(List.of(devServer));

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

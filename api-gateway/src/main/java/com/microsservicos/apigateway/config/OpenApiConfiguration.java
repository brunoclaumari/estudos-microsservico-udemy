package com.microsservicos.apigateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
//import io.swagger.v3.oas.models.servers.Server;


@Configuration
@OpenAPIDefinition(
		  servers = {
		    @Server(url = "/book-service/**", description = "URL book-service"),
		    @Server(url = "/cambio-service/**", description = "URL cambio-service")
		  }
		)
public class OpenApiConfiguration {

	
	@Bean
	@Lazy(false)
	public List<GroupedOpenApi> apis(
			SwaggerUiConfigParameters configParameters,
			RouteDefinitionLocator locator
			) {
		
		var definitions = locator.getRouteDefinitions().collectList().block();
		
		definitions.stream().filter(
				routeDefinition -> routeDefinition.getId()
				.matches(".*-service")
				).forEach(routeDefinition -> {
					String name = routeDefinition.getId();
					configParameters.addGroup(name);
					GroupedOpenApi.builder()
						.pathsToMatch("/" + name + "/**")
						.group(name).build();
				});
		
		return new ArrayList<>();
	}

}

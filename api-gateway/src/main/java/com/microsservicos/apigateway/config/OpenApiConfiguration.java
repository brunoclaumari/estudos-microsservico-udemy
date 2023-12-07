package com.microsservicos.apigateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Configuration;
//import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class OpenApiConfiguration {

	//@Bean
	public List<GroupedOpenApi> apis(
			SwaggerUiConfigParameters configParameters,
			RouteDefinitionLocator locator
			) {
		
		var definitions = locator.getRouteDefinitions().collectList().block();
		
		return new ArrayList<>();
	}

}

package com.microsservicos.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	
	
	/*
	 * o gatewayRouter serve para configurar as rotas dos serviços que serão
	 * controlados pelo API gateway
	 * */
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f
							.addRequestHeader("Hello", "World")
							.addRequestParameter("Hello", "World"))
					.uri("http://httpbin.org:80"))
				.route(p2->p2.path("/cambio-service/**")
						.uri("lb://cambio-service")) // "lb" é para usar o Load Balancer do Eureka				
				.route(p2->p2.path("/book-service/**")
						.uri("lb://book-service"))				
				.build();
	}

}

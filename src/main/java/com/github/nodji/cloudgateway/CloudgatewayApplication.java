package com.github.nodji.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudgatewayApplication.class, args);
	}
	
	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return	builder.routes()
					.route(r -> r.path("/students/**").uri("lb://msstudents"))
					.route(r -> r.path("/scholarships/**").uri("lb://msscholarship"))
					.route(r -> r.path("/evaluators/**").uri("lb://msscholarshipevaluator"))
				.build();
	}

}

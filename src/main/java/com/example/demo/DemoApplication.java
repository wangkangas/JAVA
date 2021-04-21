package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoApplication {
// Before路由断言工厂
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
//        ZonedDateTime dateTime = LocalDateTime.now().plusMinutes(2).atZone(ZoneId.systemDefault());
//        return  routeLocatorBuilder.routes().route("/users/**",r->r.before(dateTime).uri("http://localhost:9000")).build();
//    }
//After路由断言工厂
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        ZonedDateTime dateTime = LocalDateTime.now().plusMinutes(2).atZone(ZoneId.systemDefault());
        return  routeLocatorBuilder.routes().route("/users/**",r->r.after(dateTime).uri("http://localhost:9000")).build();
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

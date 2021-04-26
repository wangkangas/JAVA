package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope
@SpringBootApplication
@EnableDiscoveryClient

public class DemoApplication {
    @Value("${version.message}")
    private String message = null;
    @GetMapping("/version")
    public String version(){
        return  message;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

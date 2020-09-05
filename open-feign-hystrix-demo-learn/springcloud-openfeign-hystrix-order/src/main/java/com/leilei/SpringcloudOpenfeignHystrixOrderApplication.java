package com.leilei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//开启hystrix断路器
@EnableCircuitBreaker
public class SpringcloudOpenfeignHystrixOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudOpenfeignHystrixOrderApplication.class, args);
    }

}

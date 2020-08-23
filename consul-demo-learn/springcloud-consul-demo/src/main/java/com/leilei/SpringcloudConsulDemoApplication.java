package com.leilei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
// 开启 feign 调用
@EnableFeignClients
public class SpringcloudConsulDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsulDemoApplication.class, args);
    }

}

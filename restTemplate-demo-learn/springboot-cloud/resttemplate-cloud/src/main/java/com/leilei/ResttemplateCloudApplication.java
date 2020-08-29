package com.leilei;

import com.netflix.loadbalancer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ResttemplateCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResttemplateCloudApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        // 设置restTemplate编码为utf-8
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        RestTemplateInterceptor restTemplateInterceptor = new RestTemplateInterceptor();
        interceptors.add(restTemplateInterceptor);
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @Bean(name = "cloudRestTemplate")
    @LoadBalanced //负载均衡调用
    public RestTemplate cloudRestTemplate() {
        // 设置restTemplate编码为utf-8
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    public IRule ribbonRule() {
        return
        //随机负载策略
        new RandomRule();
        //轮询负载策略 默认
        // new RoundRobinRule();
        // 最低并发
//       new BestAvailableRule();
        //权重
//       new WeightedResponseTimeRule();
    }
}

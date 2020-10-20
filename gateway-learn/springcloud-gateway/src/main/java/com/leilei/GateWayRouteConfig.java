//package com.leilei;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import reactor.core.publisher.Mono;
//
///**
// * @author lei
// * @version 1.0
// * @date 2020/10/12 21:25
// * @desc gateway网关java配置路由信息
// */
//@Configuration
//public class GateWayRouteConfig {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("easy-order", r -> r.path("/order/**")
//                        .filters(f->f.prefixPath("/order"))
//                        .uri("http://localhost:9002/"))
//                .route("server-product", r -> r.path("/product/**")
//                        .filters(f->f.prefixPath("/product"))
//                        .uri("lb://demo-product"))
//                .build();
//    }
//}

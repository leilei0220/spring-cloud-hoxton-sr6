package com.boot.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/29 16:16
 * @desc
 */
@Configuration
public class AuthConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将自定义的登录拦截器添加进去 必须是使用方法获取 否则LoginInterceptor中无法注入Bean
        registry.addInterceptor(getLoginInterceptor())
                //拦截所有
                .addPathPatterns("/**")
                //排除路径  排除中的路径 不需要进行拦截
                .excludePathPatterns("/login/**");
    }

    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }
}

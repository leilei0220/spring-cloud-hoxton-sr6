package com.leilei;

import com.alibaba.fastjson.JSON;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;


/**
 * @author lei
 * @version 1.0
 * @date 2020/10/20 22:18
 * @desc
 */
@Component
public class AuthLoginConfig implements GlobalFilter, Ordered {
    /**
     * filter 做业务逻辑处理，选择将请求是否交由下一个过滤器或者响应出去
     * @param exchange
     * @param chain
     * @return
     */
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if ("/product/findProductByName".equals(exchange.getRequest().getURI().getPath())) {
            //一些特定的Url 放行
            return chain.filter(exchange);
        }
        String token =exchange.getRequest().getHeaders().getFirst("x-request-token");
        //根据自己需，验证对比token
        if(token == null) {
            byte[] bytes = JSON.toJSONString(Result.failure("需要登录", -2)).getBytes(StandardCharsets.UTF_8);
            ServerHttpResponse response = exchange.getResponse();
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            //响应出去
            return response.writeWith(Mono.just(buffer));
        }
        //如果存在,则放行交给下个filter
        return chain.filter(exchange);
    }

    /**
     * 指定过滤器的执行顺序 , 返回值越小,执行优先级越高
     */
    public int getOrder() {
        return 0;
    }
}

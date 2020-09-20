package com.leilei;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lei
 * @version 1.0
 * @date 2020/9/20 21:52
 * @desc
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤器类型，前置过滤器  后置 访问时 等  登陆肯定是请求接口前进行判断 ，此处为前置
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行优先级，值越小则优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return -1;
    }

    /**
     * 过滤器是否生效，true则生效，且需要执行下方run方法逻辑
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //如果是访问 /leilei/order/place/order 则需要登录，其余则不需要
        if ("/leilei/order/place/order".equalsIgnoreCase(request.getRequestURI())) {
            return true;
        }

        return false;
    }

    /**
     * 登录校验模拟
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取上下文对象
        RequestContext requestContext =  RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //模拟获取token 进行判断
        String token = request.getHeader("Authorization");

        if(StringUtils.isBlank((token))){
            token  = request.getParameter("Authorization");
        }
        //登录校验逻辑  根据业务场景自定义
        if (StringUtils.isBlank(token)) {
            requestContext.setSendZuulResponse(false);
            //返回响应码 401
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.setResponseBody(JSON.toJSONString(Result.builder()
                    .code(HttpStatus.UNAUTHORIZED.value())
                    .message("not-login")
                    .data(null)
                    .build()));
        }
        return null;
    }
}

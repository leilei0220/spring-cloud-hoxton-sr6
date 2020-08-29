package com.boot.config;

import com.alibaba.fastjson.JSON;
import com.boot.entity.Result;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/29 16:06
 * @desc
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String login = request.getHeader("login");
        if (login == null || !login.equals("abc")) {
            response.setHeader("Content-Type", "application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(JSON.toJSONString(Result.failureMessage("当前请求需要登录")));
            return false;
        }
        return true;

    }

}


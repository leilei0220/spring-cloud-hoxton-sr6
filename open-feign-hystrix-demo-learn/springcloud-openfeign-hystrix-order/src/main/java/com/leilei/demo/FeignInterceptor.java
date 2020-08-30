package com.leilei.demo;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/30 22:28
 * @desc feign 请求头传递
 */
@Configuration
public class FeignInterceptor implements RequestInterceptor {
  /**
   * 复写feign请求对象
   * @param requestTemplate
   */
  @Override
  public void apply(RequestTemplate requestTemplate) {
    //获取请求头
    Map<String,String> headers = getHeaders(getHttpServletRequest());
    for(String headerName : headers.keySet()){
      requestTemplate.header(headerName, getHeaders(getHttpServletRequest()).get(headerName));
    }
  }
  //获取请求对象
  private HttpServletRequest getHttpServletRequest() {
    try {
      return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  //拿到请求头信息
  private Map<String, String> getHeaders(HttpServletRequest request) {
    Map<String, String> map = new LinkedHashMap<>();
    Enumeration<String> enumeration = request.getHeaderNames();
    while (enumeration.hasMoreElements()) {
      String key = enumeration.nextElement();
      String value = request.getHeader(key);
      map.put(key, value);
    }
    return map;
  }
}

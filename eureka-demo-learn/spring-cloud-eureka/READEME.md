## spring-cloud
eureka-server 

使用eureka 作为微服务注册中心   用于服务注册与发现

    在eureka server端关闭自我保护机制  官方并不建议在生产情况下关闭
    - eureka.server.enable-self-preservation=false  #关闭自我保护
    - eureka.server.eviction-interval-timer-in-ms=3000 #超时3s自动清除

注意点：关闭自我注册 否则启动报错

eureka 停止更新：
    
    # 1.官方停止更新说明
    - https://github.com/Netflix/eureka/wiki
    - 在1.x版本项目还是活跃的,但是在2.x版本中停止维护,出现问题后果自负!!!
    

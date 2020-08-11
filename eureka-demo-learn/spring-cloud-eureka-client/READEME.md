##eureka 客户端

实际上 除开 eureka server 即服务端 
我们编写的每个额外微服务都是其模式下的客户端
- 用户服务
- 文件服务
- 支付服务等
如果使用eureka 作为注册中心 那么这些则都为 eureka的客户端

----
操作：
```markdown
1.引入依赖
2.配置
3.启动类注解开启
```
注意事项： 启动后就自己关闭
需引入依赖
```markdown
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```
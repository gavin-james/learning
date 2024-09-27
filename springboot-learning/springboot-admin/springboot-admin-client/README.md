# spring-boot-demo-admin-client

> 本 demo 主要演示了普通项目如何集成 Spring Boot Admin，并把自己的运行状态交给 Spring Boot Admin 进行展现。

## build.gradle

```groovy
dependencies {
    implementation(
            "org.springframework.boot:spring-boot-starter-web",
            "de.codecentric:spring-boot-admin-starter-client",
    )
}
```

## application.yml

```yaml
server:
  port: 8080
  servlet:
    context-path: /demo
spring:
  application:
    # Spring Boot Admin展示的客户端项目名，不设置，会使用自动生成的随机id
    name: spring-boot-demo-admin-client
  boot:
    admin:
      client:
        # Spring Boot Admin 服务端地址
        url: "http://localhost:8000/"
        instance:
          metadata:
            # 客户端端点信息的安全认证信息
            user.name: ${spring.security.user.name}
            user.password: ${spring.security.user.password}
  security:
    user:
      name: xkcoding
      password: 123456
management:
  endpoint:
    health:
      # 端点健康情况，默认值"never"，设置为"always"可以显示硬盘使用情况和线程情况
      show-details: always
  endpoints:
    web:
      exposure:
        # 设置端点暴露的哪些内容，默认["health","info"]，设置"*"代表暴露所有可访问的端点
        include: "*"
```


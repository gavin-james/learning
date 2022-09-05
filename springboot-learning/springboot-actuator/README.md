# springboot-actuator

> 本 demo 主要演示了如何在 Spring Boot 中通过 actuator 检查项目运行情况

## pom.xml

```groovy
dependencies {
    implementation(
            "org.springframework.boot:spring-boot-starter-webflux",
            "org.springframework.boot:spring-boot-starter-actuator"
    )
}
```

## application.yml

```yaml
server:
  port: 9000
# 若要访问端点信息，需要配置用户名和密码
spring:
  security:
    user:
      name: admin
      password: 123456
management:
  # 端点信息接口使用的端口，为了和主系统接口使用的端口进行分离
  server:
    port: 9001
  # 端点健康情况，默认值"never"，设置为"always"可以显示硬盘使用情况和线程情况
  endpoint:
    health:
      show-details: always
  # 设置端点暴露的哪些内容，默认["health","info"]，设置"*"代表暴露所有可访问的端点
  endpoints:
    web:
      exposure:
        include: '*'
```

## 端点暴露地址

将项目运行起来之后，会在**控制台**里查看所有可以访问的端口信息
1. 打开浏览器，访问：http://localhost:9001/sys/actuator/mappings ，输入用户名(admin)密码(123456)即可看到所有的mapping信息
2. 访问：http://localhost:9001/sys/actuator/beans ，输入用户名(admin)密码(123456)即可看到所有 Spring 管理的Bean
3. 其余可访问的路径，参见文档

## 参考

- actuator文档：https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/#production-ready
- 具体可以访问哪些路径，参考: https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/#production-ready-endpoints
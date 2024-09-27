# spring-boot-demo-admin-server

> 本 demo 主要演示了如何搭建一个 Spring Boot Admin 的服务端项目，可视化展示自己客户端项目的运行状态。

## build.gradle

```groovy
dependencies {
    implementation(
            "org.springframework.boot:spring-boot-starter-web",
            "de.codecentric:spring-boot-admin-starter-server",
    )
}
```

## SpringBootDemoAdminServerApplication.java

```java
/**
 * <p>
 * 启动类
 * </p>
 *
 * @author gavin james
 */
@EnableAdminServer
@SpringBootApplication
public class SpringBootDemoAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoAdminServerApplication.class, args);
    }
}
```

## application.yml

```yaml
server:
  port: 8000
```


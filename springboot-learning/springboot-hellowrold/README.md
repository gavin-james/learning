# spring-boot-demo-helloworld

## Runing spring boot demo helloworld

```sh
 $ mvn spring-boot:run
```

##

> 本 demo 演示如何使用 Spring Boot 写一个hello world

## build.gradle

```groovy
dependencies {
    implementation(
            "org.springframework.boot:spring-boot-starter-web",
            "org.springframework.boot:spring-boot-starter-undertow",
    )
}
```

### SpringBootDemoHelloworldApplication.java

```java
/**
 * <p>
 * SpringBoot启动类
 * </p>
 *
 * @author gavin james
 */
@SpringBootApplication
@RestController
public class SpringBootDemoHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoHelloworldApplication.class, args);
    }

    /**
     * Hello，World
     *
     * @param who 参数，非必须
     * @return Hello, ${who}
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        if (StrUtil.isBlank(who)) {
            who = "World";
        }
        return StrUtil.format("Hello, {}!", who);
    }
}
```
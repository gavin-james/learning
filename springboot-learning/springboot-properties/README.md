# spring-boot-demo-properties

> 本 demo 演示如何获取配置文件的自定义配置，以及如何多环境下的配置文件信息的获取
## build.gradle

```groovy
dependencies {
    implementation(
            "org.springframework.boot:spring-boot-starter-web",
            "org.springframework.boot:spring-boot-starter-undertow",
    )
    // 注解依赖
    annotationProcessor(
            // 配置文件解析
            'org.springframework.boot:spring-boot-configuration-processor'
    )
}
```


## ApplicationProperty.java

```java
/**
 * <p>
 * 项目配置
 * </p>
 *
 * @author gavin james
 */
@Data
@Component
public class ApplicationProperty {
	@Value("${application.name}")
	private String name;
	@Value("${application.version}")
	private String version;
}
```

## DeveloperProperty.java

```java
/**
 * <p>
 * 开发人员配置信息
 * </p>
 *
 * @author gavin james
 */
@Data
@ConfigurationProperties(prefix = "developer")
@Component
public class DeveloperProperty {
	private String name;
	private String website;
	private String qq;
	private String phoneNumber;
}
```

## PropertyController.java

```java
/**
 * <p>
 * 测试Controller
 * </p>
 *
 * @author gavin james
 */
@RestController
@RequiredArgsConstructor
public class PropertyController {
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @GetMapping("/property")
    public Dict index() {
        return Dict.create().set("applicationProperty", applicationProperty).set("developerProperty", developerProperty);
    }
}

```

## spring-configuration-metadata.json

> 位置： src/main/resources/META-INF/spring-configuration-metadata.json

```json
{
  "groups": [
    {
      "name": "developer",
      "type": "com.gavin.james.property.DeveloperProperty",
      "sourceType": "com.gavin.james.property.DeveloperProperty"
    }
  ],
  "properties": [
    {
      "name": "developer.name",
      "type": "java.lang.String",
      "sourceType": "com.gavin.james.property.DeveloperProperty"
    },
    {
      "name": "developer.phone-number",
      "type": "java.lang.String",
      "sourceType": "com.gavin.james.property.DeveloperProperty"
    },
    {
      "name": "developer.qq",
      "type": "java.lang.String",
      "sourceType": "com.gavin.james.property.DeveloperProperty"
    },
    {
      "name": "developer.website",
      "type": "java.lang.String",
      "sourceType": "com.gavin.james.property.DeveloperProperty"
    }
  ],
  "hints": []
}
```


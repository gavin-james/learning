# 接口文档

[gitee地址](https://gitee.com/xiaoym/knife4j)
[官网](https://doc.xiaominfo.com/)
[openApi3](https://springdoc.org/#migrating-from-springfox)

## 1、整合 knife4j

引入依赖

```xml
<!-- 2.x版本依赖 -->
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-spring-boot-starter</artifactId>
    <version>2.0.7</version>
</dependency>

        <!-- 3.x版本依赖（支持 openApi3 ） -->
<dependency>
<groupId>com.github.xiaoymin</groupId>
<artifactId>knife4j-spring-boot-starter</artifactId>
<version>3.0.3</version>
</dependency>
```

Gradle

```groovy
    implementation "com.github.xiaoymin:knife4j-spring-boot-starter:3.0.3"
implementation "com.github.xiaoymin:knife4j-spring-boot-starter:3.0.3"
```


```
@Api → @Tag

@ApiIgnore → @Parameter(hidden = true) or @Operation(hidden = true) or @Hidden

@ApiImplicitParam → @Parameter

@ApiImplicitParams → @Parameters

@ApiModel → @Schema

@ApiModelProperty(hidden = true) → @Schema(accessMode = READ_ONLY)

@ApiModelProperty → @Schema

@ApiOperation(value = "foo", notes = "bar") → @Operation(summary = "foo", description = "bar")

@ApiParam → @Parameter

@ApiResponse(code = 404, message = "foo") → @ApiResponse(responseCode = "404", description = "foo")
```
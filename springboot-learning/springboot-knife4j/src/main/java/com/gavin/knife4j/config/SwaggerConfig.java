/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.gavin.knife4j.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 创建Swagger配置
 * @since:knife4j-springdoc-openapi-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/15 20:40
 */
@Configuration
public class SwaggerConfig {


  @Bean
  public GroupedOpenApi userApi() {
    String[] paths = {"/**"};
    String[] packagedToMatch = {"com.gavin.knife4j.controller"};
    return GroupedOpenApi.builder().group("用户模块")
            .pathsToMatch(paths)
            .addOperationCustomizer((operation, handlerMethod) -> operation.addParametersItem(new HeaderParameter().name("groupCode").example("测试").description("集团code").schema(new StringSchema()._default("BR").name("groupCode").description("集团code"))))
            .packagesToScan(packagedToMatch).build();
  }

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .info(new Info()
                    .title("XXX用户系统API")
                    .version("1.0")
                    .description("Knife4j集成springdoc-openapi示例")
                    .termsOfService("http://doc.xiaominfo.com")
                    .license(new License().name("Apache 2.0")
                            .url("http://doc.xiaominfo.com")));
  }


}

//package com.gavin.knife4j.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//public class Knife4jConfiguration {
//
//  @Bean
//  public Docket publicApi() {
//    return new Docket(DocumentationType.OAS_30)
//            .apiInfo(ApiInfo.DEFAULT)
//            .groupName("1.X版本")
//            .select()
//            //这里指定Controller扫描包路径
//            .apis(RequestHandlerSelectors.basePackage("com.gavin.knife4j.controller"))
//            .paths(PathSelectors.any())
//            .build();
//  }
//
//  @Bean
//  public Docket adminApi() {
//    return new Docket(DocumentationType.OAS_30)
//            .apiInfo(ApiInfo.DEFAULT)
//            .groupName("2.X版本")
//            .select()
//            //这里指定Controller扫描包路径
//            .apis(RequestHandlerSelectors.basePackage("com.gavin.knife4j.controller"))
//            .paths(PathSelectors.any())
//            .build();
//  }
//
//}
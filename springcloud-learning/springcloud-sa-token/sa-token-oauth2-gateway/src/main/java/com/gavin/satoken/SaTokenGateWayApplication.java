package com.gavin.satoken;

import com.alibaba.cloud.nacos.ConditionalOnNacosDiscoveryEnabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SaTokenGateWayApplication {

  public static void main(String[] args) {
    SpringApplication.run(SaTokenGateWayApplication.class, args);
  }

}

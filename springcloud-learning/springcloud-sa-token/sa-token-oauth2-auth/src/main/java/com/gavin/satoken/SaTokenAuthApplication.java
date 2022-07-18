package com.gavin.satoken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SaTokenAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(SaTokenAuthApplication.class, args);
  }

}

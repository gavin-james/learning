package com.gavin.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Gavin
 */
@EnableCaching
@SpringBootApplication
public class CacheSpringApplication {
  public static void main(String[] args) {
    SpringApplication.run(CacheSpringApplication.class, args);
  }
}

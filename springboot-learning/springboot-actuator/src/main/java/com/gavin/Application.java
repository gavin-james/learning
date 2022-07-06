package com.gavin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author gavin
 * @date 2021/7/6 0006 1:49
 */
@SpringBootApplication
@RestController
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @RequestMapping("hello")
  public String hello() {
    return "hello";
  }

  @RequestMapping("mono")
  public Mono<String> mono() {
    return Mono.just("测试呀");
  }

}

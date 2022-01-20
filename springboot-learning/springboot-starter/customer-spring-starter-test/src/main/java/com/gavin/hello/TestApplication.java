package com.gavin.hello;

import com.gavin.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestApplication {

  @Autowired
  HelloService helloService;

  @GetMapping("hello")
  public String get() {
    return helloService.sayHello();
  }

  public static void main(String[] args) {
    SpringApplication.run(TestApplication.class, args);
  }

}

package com.gavin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
  @GetMapping("hello")
  public String test() {
    log.info("开始调用hello方法");
    return "hello";
  }
}

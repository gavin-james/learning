package com.gavin.hello.service;

import com.gavin.hello.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

  @Autowired
  HelloProperties helloProperties;

  public String sayHello() {
    return helloProperties.getName() + "对你说" + helloProperties.getMsg();
  }
}

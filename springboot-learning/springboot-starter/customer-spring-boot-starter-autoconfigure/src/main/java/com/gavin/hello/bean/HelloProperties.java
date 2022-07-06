package com.gavin.hello.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("gavin.hello")
public class HelloProperties {
  private String name;
  private String msg;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}

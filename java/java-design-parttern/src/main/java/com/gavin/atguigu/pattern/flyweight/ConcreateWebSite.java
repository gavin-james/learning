package com.gavin.atguigu.pattern.flyweight;

// 具体网站
public class ConcreateWebSite extends WebSite {

  private String type = "";// 网站发布的形式

  public ConcreateWebSite(String type) {
    this.type = type;
  }

  @Override
  public void use() {
    System.out.println("网站的发布形式：" + type);
  }
}

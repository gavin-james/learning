package com.gavin.atguigu.pattern.template;

public class Client {
  public static void main(String[] args) {
    SoyaMilk soyaMilk = new RedBeanSoyaMilk();
    soyaMilk.make();
    soyaMilk = new PeanutSoyaMilk();
    soyaMilk.make();
  }
}

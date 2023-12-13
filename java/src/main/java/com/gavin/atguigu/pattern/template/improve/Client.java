package com.gavin.atguigu.pattern.template.improve;



public class Client {
  public static void main(String[] args) {
    System.out.println("----红豆豆浆----");
    SoyaMilk soyaMilk = new RedBeanSoyaMilk();
    soyaMilk.make();
    System.out.println("----花生豆浆----");
    soyaMilk = new PeanutSoyaMilk();
    soyaMilk.make();
    System.out.println("----原味豆浆----");
    soyaMilk = new PureSoyaMilk();
    soyaMilk.make();

  }
}

package com.gavin.atguigu.pattern.factory.absfactory.pizza;


public class BjCheessPizza extends Pizza {
  @Override
  public void prepare() {
    setName("北京奶酪披萨");
    System.out.println("给北京奶酪披萨 准备材料");
  }
}

package com.gavin.atguigu.pattern.factory.simplefactory.pizza;

public class CheessPizza extends Pizza {
  @Override
  public void prepare() {
    System.out.println("给奶酪披萨 准备材料");
  }
}

package com.gavin.atguigu.pattern.factory.absfactory.pizza;


public class BjPepperPizza extends Pizza {
  @Override
  public void prepare() {
    setName("北京胡椒披萨");
    System.out.println("给北京胡椒披萨 准备材料");
  }
}

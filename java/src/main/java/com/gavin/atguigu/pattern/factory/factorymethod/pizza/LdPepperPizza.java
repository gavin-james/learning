package com.gavin.atguigu.pattern.factory.factorymethod.pizza;


public class LdPepperPizza extends Pizza {
  @Override
  public void prepare() {
    setName("伦敦胡椒披萨");
    System.out.println("给伦敦胡椒披萨 准备材料");
  }
}

package com.gavin.atguigu.pattern.factory.absfactory.pizza;


public class LdCheessPizza extends Pizza {
  @Override
  public void prepare() {
    setName("伦敦奶酪披萨");
    System.out.println("给伦敦奶酪披萨 准备材料");
  }
}

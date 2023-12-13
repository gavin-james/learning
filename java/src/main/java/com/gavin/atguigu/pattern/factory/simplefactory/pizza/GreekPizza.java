package com.gavin.atguigu.pattern.factory.simplefactory.pizza;

public class GreekPizza extends Pizza{
  @Override
  public void prepare() {
    System.out.println("给希腊披萨 准备材料");
  }
}

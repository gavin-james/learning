package com.gavin.atguigu.pattern.factory.absfactory.order;

// 披萨商店
public class PizzaStore {

  public static void main(String[] args) {
    new OrderPizza(new LdFactory());
  }
}

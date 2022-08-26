package com.gavin.atguigu.pattern.factory.factorymethod.order;


import com.gavin.atguigu.pattern.factory.factorymethod.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class OrderPizza {

  abstract Pizza createPizza(String orderType);

  // 准备一 个工厂
  public OrderPizza() {
    Pizza pizza = null;
    do {
      pizza = createPizza(gettype());
      // Pizza 制作过程
      pizza.prepare();
      pizza.bake();
      pizza.cut();
      pizza.box();
    } while (true);
  }


  // 获取输入的类型
  private String gettype() {
    try {
      BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("input pizza type:");
      String str = strin.readLine();
      return str;
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  }
}

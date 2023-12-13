package com.gavin.atguigu.pattern.factory.absfactory.order;


import com.gavin.atguigu.pattern.factory.absfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {

  AbsFactory absFactory;


  // 准备一 个工厂
  public OrderPizza(AbsFactory absFactory) {
    Pizza pizza = null;
    this.absFactory = absFactory;

    do {
      pizza = absFactory.createPizza(gettype());
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

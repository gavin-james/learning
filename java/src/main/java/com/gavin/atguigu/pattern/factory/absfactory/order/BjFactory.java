package com.gavin.atguigu.pattern.factory.absfactory.order;

import com.gavin.atguigu.pattern.factory.absfactory.pizza.BjCheessPizza;
import com.gavin.atguigu.pattern.factory.absfactory.pizza.BjPepperPizza;
import com.gavin.atguigu.pattern.factory.absfactory.pizza.Pizza;

public class BjFactory implements AbsFactory {
  @Override
  public Pizza createPizza(String orderType) {
    if (orderType.equals("greek")) {
      return new BjPepperPizza();
    } else if (orderType.equals("cheese")) {
      return new BjCheessPizza();
    }

    return null;
  }
}

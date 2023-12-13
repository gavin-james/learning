package com.gavin.atguigu.pattern.factory.absfactory.order;

import com.gavin.atguigu.pattern.factory.absfactory.pizza.LdCheessPizza;
import com.gavin.atguigu.pattern.factory.absfactory.pizza.LdPepperPizza;
import com.gavin.atguigu.pattern.factory.absfactory.pizza.Pizza;

public class LdFactory implements AbsFactory {
  @Override
  public Pizza createPizza(String orderType) {

    if (orderType.equals("greek")) {
      return new LdCheessPizza();
    } else if (orderType.equals("cheese")) {
      return new LdPepperPizza();
    }

    return null;
  }
}

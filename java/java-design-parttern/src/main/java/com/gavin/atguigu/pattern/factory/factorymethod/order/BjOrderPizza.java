package com.gavin.atguigu.pattern.factory.factorymethod.order;

import com.gavin.atguigu.pattern.factory.factorymethod.pizza.BjCheessPizza;
import com.gavin.atguigu.pattern.factory.factorymethod.pizza.BjPepperPizza;
import com.gavin.atguigu.pattern.factory.factorymethod.pizza.Pizza;

public class BjOrderPizza extends OrderPizza {
  @Override
  Pizza createPizza(String orderType) {
    if (orderType.equals("pepper")) {
      return new BjPepperPizza();
    } else if (orderType.equals("cheese")) {
      return new BjCheessPizza();
    } else {
      return null;
    }
  }
}

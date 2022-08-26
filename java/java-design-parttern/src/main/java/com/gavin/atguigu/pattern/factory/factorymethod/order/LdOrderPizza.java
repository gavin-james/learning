package com.gavin.atguigu.pattern.factory.factorymethod.order;

import com.gavin.atguigu.pattern.factory.factorymethod.pizza.LdCheessPizza;
import com.gavin.atguigu.pattern.factory.factorymethod.pizza.LdPepperPizza;
import com.gavin.atguigu.pattern.factory.factorymethod.pizza.Pizza;

public class LdOrderPizza extends OrderPizza {
  @Override
  Pizza createPizza(String orderType) {
    if (orderType.equals("pepper")) {
      return new LdPepperPizza();
    } else if (orderType.equals("cheese")) {
      return new LdCheessPizza();
    } else {
      return null;
    }
  }
}

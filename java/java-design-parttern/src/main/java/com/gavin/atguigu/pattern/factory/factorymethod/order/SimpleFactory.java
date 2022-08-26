package com.gavin.atguigu.pattern.factory.factorymethod.order;

import com.gavin.atguigu.pattern.factory.simplefactory.pizza.CheessPizza;
import com.gavin.atguigu.pattern.factory.simplefactory.pizza.GreekPizza;
import com.gavin.atguigu.pattern.factory.simplefactory.pizza.Pizza;

/**
 * 简单工厂类
 */
public class SimpleFactory {

  public Pizza createPizza(String orderType) {
    Pizza pizza = null;
    System.out.println("使用简单工厂模式");
    switch (orderType) {
      case "greek":
        pizza = new GreekPizza();
        pizza.setName("希腊披萨");
        break;
      case "cheese":
        pizza = new CheessPizza();
        pizza.setName("奶酪披萨");
        break;
    }

    return pizza;
  }
  public static Pizza staticCreatePizza(String orderType) {
    Pizza pizza = null;
    System.out.println("使用简单工厂模式");
    switch (orderType) {
      case "greek":
        pizza = new GreekPizza();
        pizza.setName("希腊披萨");
        break;
      case "cheese":
        pizza = new CheessPizza();
        pizza.setName("奶酪披萨");
        break;
    }

    return pizza;
  }


}

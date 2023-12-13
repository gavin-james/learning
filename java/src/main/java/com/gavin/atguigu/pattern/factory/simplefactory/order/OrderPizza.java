package com.gavin.atguigu.pattern.factory.simplefactory.order;

import com.gavin.atguigu.pattern.factory.simplefactory.pizza.CheessPizza;
import com.gavin.atguigu.pattern.factory.simplefactory.pizza.GreekPizza;
import com.gavin.atguigu.pattern.factory.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {

  // 准备一 个工厂
  public OrderPizza() {
//    Pizza pizza = null;
//    String orderType;
//    do {
//      orderType = gettype();
//      if (orderType.equals("greek")) {
//        pizza = new GreekPizza();
//      } else if (orderType.equals("cheese")) {
//        pizza = new CheessPizza();
//      } else {
//        break;
//      }
//      pizza.setName(orderType);
//      // Pizza 制作过程
//      pizza.prepare();
//      pizza.bake();
//      pizza.cut();
//      pizza.box();
//    } while (true);

    do {
      pizza = SimpleFactory.staticCreatePizza(gettype());
      if (pizza != null) {
        // Pizza 制作过程
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
      }
    } while (true);
  }

  // 构造器
  public OrderPizza(SimpleFactory simpleFactory) {
    setSimpleFactory(simpleFactory);
  }

  SimpleFactory simpleFactory;
  Pizza pizza;

  public void setSimpleFactory(SimpleFactory simpleFactory) {
    String orderType = "";
    this.simpleFactory = simpleFactory;

    do {
      pizza = simpleFactory.createPizza(gettype());
      if (pizza != null) {
        // Pizza 制作过程
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
      }
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

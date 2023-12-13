package com.gavin.atguigu.pattern.decorator;

public class Milk extends Decorator {
  public Milk(Drink drink) {
    super(drink);
    setDes(" 牛奶 ");
    setPrice(5.0f);
  }
}

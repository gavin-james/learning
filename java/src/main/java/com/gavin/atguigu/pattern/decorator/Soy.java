package com.gavin.atguigu.pattern.decorator;

public class Soy extends Decorator{
  public Soy(Drink drink) {
    super(drink);
    setDes(" 豆浆 ");
    setPrice(1.5f);
  }
}

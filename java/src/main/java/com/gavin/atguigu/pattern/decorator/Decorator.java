package com.gavin.atguigu.pattern.decorator;

public class Decorator extends Drink {

  private Drink drink;

  public Decorator(Drink drink) {
    this.drink = drink;
  }

  @Override
  public float cost() {
    return super.getPrice() + drink.cost();
  }

  @Override
  public String getDes() {
    return des + "  " + getPrice() + "&&" + drink.getDes();
  }
}

package com.gavin.atguigu.pattern.decorator;

public class CoffeeBar {
  public static void main(String[] args) {
    Drink chocolate = new Chocolate(new Chocolate(new Soy(new LongBlack())));

    System.out.println(chocolate.cost());
    System.out.println(chocolate.getDes());

  }
}

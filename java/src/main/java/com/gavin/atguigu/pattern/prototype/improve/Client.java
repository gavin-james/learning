package com.gavin.atguigu.pattern.prototype.improve;

public class Client {
  public static void main(String[] args) throws CloneNotSupportedException {
    Sheep sheep = new Sheep("tom",18,"white");
    Sheep sheep1 = (Sheep) sheep.clone();

    System.out.println(sheep1);
    System.out.println(sheep1.hashCode()+"--"+sheep.hashCode());
  }
}

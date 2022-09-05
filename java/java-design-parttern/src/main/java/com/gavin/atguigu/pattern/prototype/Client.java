package com.gavin.atguigu.pattern.prototype;

public class Client {
  public static void main(String[] args) {
    Sheep sheep = new Sheep("tom",18,"white");
    Sheep sheep1 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
    Sheep sheep2 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
    Sheep sheep3 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
    Sheep sheep4 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());


  }
}

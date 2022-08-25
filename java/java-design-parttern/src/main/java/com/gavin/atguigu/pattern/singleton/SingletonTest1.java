package com.gavin.atguigu.pattern.singleton;


public class SingletonTest1 {
  public static void main(String[] args) {
    Singleton1 instance = Singleton1.getInstance();
    Singleton1 instance2 = Singleton1.getInstance();
    System.out.println(instance2 == instance);
    System.out.println(instance.hashCode());
    System.out.println(instance2.hashCode());
  }
}

// 饿汉式（静态变量）
class Singleton1 {

  // 1.构造器私有化，外部能new
  private Singleton1() {

  }

  // 2.本类内部创建对象案例
  private final static Singleton1 instance = new Singleton1();

  // 3.提供一个共有的静态方法，返回实例对象
  public static Singleton1 getInstance() {
    return instance;
  }
}
package com.gavin.atguigu.pattern.singleton;


public class SingletonTest7 {
  public static void main(String[] args) {
    Singleton7 instance = Singleton7.INSTANCE;
    Singleton7 instance2 = Singleton7.INSTANCE;
    System.out.println(instance2 == instance);
    System.out.println(instance.hashCode());
    instance.sayHello();
    System.out.println(instance2.hashCode());
    instance2.sayHello();
  }
}

// 枚举
enum Singleton7 {
  INSTANCE;// 属性

  public void sayHello() {
    System.out.println("hello~~~~");
  }
}
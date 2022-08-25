package com.gavin.atguigu.pattern.singleton;


public class SingletonTest2 {
  public static void main(String[] args) {
    Singleton2 instance = Singleton2.getInstance();
    Singleton2 instance2 = Singleton2.getInstance();
    System.out.println(instance2 == instance);
    System.out.println(instance.hashCode());
    System.out.println(instance2.hashCode());
  }
}

// 饿汉式（静态代码块）
class Singleton2 {
  // 1.构造器私有化，外部能new
  private Singleton2() {

  }

  // 2.本类内部创建对象案例
  private static Singleton2 instance;

  static { // 在静态代码块中，创建单例对象
    instance = new Singleton2();
  }

  // 3.提供一个共有的静态方法，返回实例对象
  public static Singleton2 getInstance() {
    return instance;
  }
}
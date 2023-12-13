package com.gavin.atguigu.pattern.singleton;


public class SingletonTest3 {
  public static void main(String[] args) {
    Singleton3 instance = Singleton3.getInstance();
    Singleton3 instance2 = Singleton3.getInstance();
    System.out.println(instance2 == instance);
    System.out.println(instance.hashCode());
    System.out.println(instance2.hashCode());
  }
}

// 懒汉式(线程不安全的)
class Singleton3 {
  private static Singleton3 instance;

  private Singleton3() {

  }

  // 提供一个公有的静态方法，当使用到该方法时，采取创建 instance
  // 即懒汉式
  public static Singleton3 getInstance() {
    if (instance == null) {
      instance = new Singleton3();
    }
    return instance;
  }
}
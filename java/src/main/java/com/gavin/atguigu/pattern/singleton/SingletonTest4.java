package com.gavin.atguigu.pattern.singleton;


public class SingletonTest4 {
  public static void main(String[] args) {
    Singleton4 instance = Singleton4.getInstance();
    Singleton4 instance2 = Singleton4.getInstance();
    System.out.println(instance2 == instance);
    System.out.println(instance.hashCode());
    System.out.println(instance2.hashCode());
  }
}

// 懒汉式(线程安全的)
class Singleton4 {
  private static Singleton4 instance;

  private Singleton4() {

  }

  // 提供一个公有的静态方法，加入同步处理的代码，解决线程安全问题
  // 即懒汉式
  public static synchronized Singleton4 getInstance() {
    if (instance == null) {
      instance = new Singleton4();
    }
    return instance;
  }
}
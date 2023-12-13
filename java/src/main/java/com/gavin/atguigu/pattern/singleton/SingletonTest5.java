package com.gavin.atguigu.pattern.singleton;


public class SingletonTest5 {
  public static void main(String[] args) {
    Singleton5 instance = Singleton5.getInstance();
    Singleton5 instance2 = Singleton5.getInstance();
    System.out.println(instance2 == instance);
    System.out.println(instance.hashCode());
    System.out.println(instance2.hashCode());
  }
}

// 懒汉式(双重检查)
class Singleton5 {
  private static volatile Singleton5 instance;

  private Singleton5() {

  }

  // 提供一个公有的静态方法，加入双重检查代码，解决线程安全问题，同时解决懒加载问题
  // 即懒汉式，保证了效率
  public static Singleton5 getInstance() {
    if (instance == null) {
      synchronized (Singleton5.class) {
        if (instance == null) {
          instance = new Singleton5();
        }
      }
    }
    return instance;
  }
}
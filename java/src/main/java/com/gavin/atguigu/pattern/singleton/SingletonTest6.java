package com.gavin.atguigu.pattern.singleton;


public class SingletonTest6 {
  public static void main(String[] args) {
    Singleton6 instance = Singleton6.getInstance();
    Singleton6 instance2 = Singleton6.getInstance();
    System.out.println(instance2 == instance);
    System.out.println(instance.hashCode());
    System.out.println(instance2.hashCode());
  }
}

// 静态内部类完成
class Singleton6 {

  // 构造器私有化
  private Singleton6() {
  }

  // 写一个静态内部类，该类中有一个静态属性 Singleton
  private static class SingletonInstance {
    private static final Singleton6 INSTANCE = new Singleton6();
  }

  // 提供一个公有的静态方法，直接返回 SingletonInstance.INSTANCE
  public static Singleton6 getInstance() {
    return SingletonInstance.INSTANCE;
  }
}
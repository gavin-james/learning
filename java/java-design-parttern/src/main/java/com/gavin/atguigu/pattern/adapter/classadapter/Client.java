package com.gavin.atguigu.pattern.adapter.classadapter;

public class Client {
  public static void main(String[] args) {
    // 适配器模式
    Phone phone = new Phone();
    phone.charging(new VoltageAdapter());
  }
}

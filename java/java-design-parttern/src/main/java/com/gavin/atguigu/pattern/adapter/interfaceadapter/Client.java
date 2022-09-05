package com.gavin.atguigu.pattern.adapter.interfaceadapter;

public class Client {
  public static void main(String[] args) {
    AbsAdapter adapter = new AbsAdapter() {
      @Override
      public void m1() {
        System.out.println("使用 m1 方法");
      }
    };
    adapter.m1();
  }
}

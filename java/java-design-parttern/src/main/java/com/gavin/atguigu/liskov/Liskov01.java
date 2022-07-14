package com.gavin.atguigu.liskov;

public class Liskov01 {
}

class A {
  public int add(int a, int b) {
    return a - b;
  }
}

// 增加了一个新功能：完成两个数的和然后再加9
class B extends A {
  @Override
  public int add(int a, int b) {
    return a + b;
  }

  public int add2(int a, int b) {
    return add(a, b) + 9;
  }
}
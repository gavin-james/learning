package com.gavin.atguigu.liskov.improve;

public class Liskov01 {
}

interface Interface {
  int add(int a, int b);
}


class A implements Interface {
  @Override
  public int add(int a, int b) {
    return a - b;
  }
}

// 增加了一个新功能：完成两个数的和然后再加9
class B implements Interface {
  private A a = new A();

  @Override
  public int add(int a, int b) {
    return a + b;
  }

  public int add2(int a, int b) {
    return add(a, b) + 9;
  }

  public int add3(int a, int b) {
    return this.a.add(a, b);
  }
}
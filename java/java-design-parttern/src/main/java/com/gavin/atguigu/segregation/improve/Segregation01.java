package com.gavin.atguigu.segregation.improve;

public class Segregation01 {

}

// 接口
interface Interface01 {
  void operation01();
}

// 接口
interface Interface02 {

  void operation02();

  void operation03();
}

// 接口
interface Interface03 {
  void operation04();

  void operation05();
}

class B implements Interface01, Interface02 {
  @Override
  public void operation01() {
    System.out.println("B 实现了 operation01");
  }

  @Override
  public void operation02() {
    System.out.println("B 实现了 operation02");
  }

  @Override
  public void operation03() {
    System.out.println("B 实现了 operation03");
  }
}

class D implements Interface01, Interface03 {
  @Override
  public void operation01() {
    System.out.println("D 实现了 operation01");
  }

  @Override
  public void operation04() {
    System.out.println("D 实现了 operation04");
  }

  @Override
  public void operation05() {
    System.out.println("D 实现了 operation05");
  }
}

// A 类通过Interface 依赖，使用 B 类 但是只会使用到 1、2、3方法
class A {

  public void depend01(Interface01 interface1) {
    interface1.operation01();
  }

  public void depend02(Interface02 interface1) {
    interface1.operation02();
  }

  public void depend03(Interface02 interface1) {
    interface1.operation03();
  }
}

// C 类通过Interface 依赖，使用 D 类 但是只会使用到 1、4、5方法
class C {

  public void depend01(Interface01 interface1) {
    interface1.operation01();
  }

  public void depend04(Interface03 interface1) {
    interface1.operation04();
  }

  public void depend05(Interface03 interface1) {
    interface1.operation05();
  }
}
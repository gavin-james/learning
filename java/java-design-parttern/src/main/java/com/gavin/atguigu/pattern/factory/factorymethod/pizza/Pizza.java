package com.gavin.atguigu.pattern.factory.factorymethod.pizza;

/**
 * 将 Pizza 抽象类
 */
public abstract class Pizza {

  protected String name;// 名字

  // 准备原材料，不同的披萨不一样，因此，我们做成抽象方法
  public abstract void prepare();

  public void bake() {
    System.out.println(name + ".....bake.....");
  }

  public void cut() {
    System.out.println(name + ".....cut.....");
  }

  public void box() {
    System.out.println(name + ".....box.....");
  }

  public void setName(String name) {
    this.name = name;
  }
}

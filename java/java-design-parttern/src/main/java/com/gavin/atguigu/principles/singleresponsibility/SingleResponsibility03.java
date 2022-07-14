package com.gavin.atguigu.principles.singleresponsibility;

public class SingleResponsibility03 {
  public static void main(String[] args) {
    Vehicle2 vehicle =new Vehicle2();
    vehicle.run("摩托车");
    vehicle.runAir("汽车");
    vehicle.runWater("飞机");
  }
}

// 交通工具类
// 方式3
// 1.这种修改方法没有对原来的类做大的修改，只是增加了方法
// 2.这里虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上，仍然遵守单一职责原则
class Vehicle2 {
  public void run(String vehicle) {
    System.out.println(vehicle + "在公路上运行。。。。");
  }
  public void runAir(String vehicle) {
    System.out.println(vehicle + "在天空上运行。。。。");
  }
  public void runWater(String vehicle) {
    System.out.println(vehicle + "在水里运行。。。。");
  }


}
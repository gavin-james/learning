package com.gavin.atguigu.pattern.adapter.classadapter;

public class Phone {


  // 充电
  public void charging(Voltage5V voltage5V) {
    if (voltage5V.out5() == 5) {
      System.out.println("电压为5v，可以充电");
    } else if (voltage5V.out5() > 5) {
      System.out.println("电压为大于5v，无法充电");
    }
  }
}

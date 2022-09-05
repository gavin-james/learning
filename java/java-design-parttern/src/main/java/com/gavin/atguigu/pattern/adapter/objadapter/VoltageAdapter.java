package com.gavin.atguigu.pattern.adapter.objadapter;

public class VoltageAdapter implements Voltage5V {

  Voltage220V voltage220V;

  public VoltageAdapter(Voltage220V voltage220V) {
    this.voltage220V = voltage220V;
  }

  @Override
  public int out5() {
    int src = voltage220V.out220();
    return src / 44;
  }
}

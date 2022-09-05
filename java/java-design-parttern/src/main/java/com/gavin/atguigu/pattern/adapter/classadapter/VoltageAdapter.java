package com.gavin.atguigu.pattern.adapter.classadapter;

public class VoltageAdapter extends Voltage220V implements Voltage5V {
  @Override
  public int out5() {
    int src = out220();
    return src / 44;
  }
}

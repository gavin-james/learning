package com.gavin.atguigu.pattern.builder.improve;

// 指挥者 这里指定指挥流程
public class HouseDirector {
  HouseBuilder houseBuilder;

  public HouseDirector(HouseBuilder houseBuilder) {
    this.houseBuilder = houseBuilder;
  }

  // 如何创建房子流程，交给指挥者
  public House constructHouse() {
    houseBuilder.buildBasic();
    houseBuilder.buildWalls();
    houseBuilder.roofed();
    return houseBuilder.buildHouse();
  }
}

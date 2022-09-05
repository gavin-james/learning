package com.gavin.atguigu.pattern.prototype.improve;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Sheep implements Cloneable {
  private String name;
  private int age;
  private String color;

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}

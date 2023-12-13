package com.gavin.atguigu.pattern.decorator;

import lombok.Data;

@Data
public abstract class Drink {

  public String des; // 描述
  private float price = 0.0f;

  public abstract float cost();
}

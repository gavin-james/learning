package com.gavin.atguigu.pattern.builder.improve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产品
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
  private String basic;
  private String wall;
  private String roofed;
}

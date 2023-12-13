package com.gavin.atguigu.pattern.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class OrganizationComponent {

  private String name;
  private String desc;

  protected void add(OrganizationComponent organizationComponent) {
    // 默认实现
    throw new UnsupportedOperationException();
  }

  protected void remove(OrganizationComponent organizationComponent) {
    // 默认实现
    throw new UnsupportedOperationException();
  }

  protected abstract void print();
}

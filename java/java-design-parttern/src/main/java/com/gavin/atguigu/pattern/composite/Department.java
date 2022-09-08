package com.gavin.atguigu.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {

  @Override
  protected void print() {
    System.out.println(getName());
  }

  public Department(String name, String desc) {
    super(name, desc);
  }
}

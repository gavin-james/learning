package com.gavin.atguigu.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class University extends OrganizationComponent {

  List<OrganizationComponent> list = new ArrayList<>();

  public University(String name, String desc) {
    super(name, desc);
  }

  @Override
  protected void print() {
    System.out.println("-----------" + getName() + "-----------");
    list.forEach(OrganizationComponent::print);
  }

  @Override
  protected void add(OrganizationComponent organizationComponent) {
    list.add(organizationComponent);
  }

  @Override
  protected void remove(OrganizationComponent organizationComponent) {
    list.remove(organizationComponent);
  }

}

package com.gavin.atguigu.pattern.template.improve;

public class PureSoyaMilk extends SoyaMilk{
  @Override
  void addCondiments() {

  }

  @Override
  boolean customerWantCondiments() {
    return false;
  }
}

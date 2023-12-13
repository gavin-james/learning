package com.gavin.atguigu.pattern.proxy.staticproxy;

public class TeacherDao implements ITeacherDdao{
  @Override
  public void teach() {
    System.out.println("老师授课中。。。。。");
  }
}

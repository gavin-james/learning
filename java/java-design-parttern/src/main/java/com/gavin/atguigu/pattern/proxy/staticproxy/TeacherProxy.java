package com.gavin.atguigu.pattern.proxy.staticproxy;

public class TeacherProxy implements ITeacherDdao {
  private ITeacherDdao teacherDdao;

  public TeacherProxy(ITeacherDdao teacherDdao) {
    this.teacherDdao = teacherDdao;
  }

  @Override
  public void teach() {
    System.out.println("开始代理。。。");
    teacherDdao.teach();
    System.out.println("代理结束。。。");
  }
}

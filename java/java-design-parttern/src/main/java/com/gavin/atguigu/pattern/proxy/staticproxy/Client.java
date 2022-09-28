package com.gavin.atguigu.pattern.proxy.staticproxy;

public class Client {
  public static void main(String[] args) {
    // 创建目标对象（被代理对象）
    TeacherDao teacherDao = new TeacherDao();

    // 创建代理对象，同时将被代理对象传递给代理对象
    TeacherProxy teacherProxy= new TeacherProxy(teacherDao);

    // 通过代理对象，调用到被代理对象到方法
    // 即；执行到是代理对象到方法，代理对象再去调用目标的方法
    teacherProxy.teach();
  }
}

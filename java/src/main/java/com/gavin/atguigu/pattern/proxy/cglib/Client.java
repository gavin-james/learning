package com.gavin.atguigu.pattern.proxy.cglib;

public class Client {
  public static void main(String[] args) {
    TeacherDao teacherDao = new TeacherDao();

    TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(teacherDao).getProxyInstance();

    proxyInstance.teach();
  }
}

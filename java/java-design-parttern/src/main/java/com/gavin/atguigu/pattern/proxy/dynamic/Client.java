package com.gavin.atguigu.pattern.proxy.dynamic;

import com.gavin.atguigu.pattern.proxy.staticproxy.ITeacherDdao;

public class Client {

  public static void main(String[] args) {

    // 创建目标对象
    ITeacherDdao teacherDdao = new TeacherDao();

    // 给目标对象，创建代理对象，可以转成ITeacherDdao
    ITeacherDdao proxyInstance = (ITeacherDdao) new ProxyFactory(teacherDdao).getProxyInstance();

    // 内存中动态生成了代理对象
    System.out.println("proxyInstance" + proxyInstance.getClass());

    // 通过代理对象调用方法
    proxyInstance.teach();
  }
}

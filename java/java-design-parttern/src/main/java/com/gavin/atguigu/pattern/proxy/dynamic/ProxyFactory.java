package com.gavin.atguigu.pattern.proxy.dynamic;

import java.lang.reflect.Proxy;

public class ProxyFactory {
  // 维护一个对象
  private Object object;

  // 构造器，对target进行初始化
  public ProxyFactory(Object object) {
    this.object = object;
  }

  //给目标对象生成一个代理对象
  public Object getProxyInstance() {
    // 说明
    // 1。loader  指定当前目标对象使用1对类加载器
    // 2。interfaces 目标对象实现对接口类型，使用泛型方法确认类型
    // 3。h 事情处理，执行目标对象对方法时，会触发事情处理器方法，会把当前执行对目标对象方法作为参数注入
    return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), (proxy, method, args) -> {
      System.out.println("jdk 代理开始～");
      // 反射机制调用目标对象对方法
      Object returnVal = method.invoke(object, args);
      return returnVal;
    });
  }
}

package com.gavin.atguigu.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

  private Object object;

  public ProxyFactory(Object object) {
    this.object = object;
  }

  public  Object getProxyInstance(){
    Enhancer enhancer = new Enhancer();

    enhancer.setSuperclass(object.getClass());

    enhancer.setCallback(this);

    return enhancer.create();
  }
  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

    System.out.println("cglib代理模式～ 开始");
    method.invoke(object,args);
    System.out.println("cglib代理模式～ 提交");
    return null;
  }
}

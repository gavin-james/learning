package com.gavin.atguigu.principles.inversion.improve;

public class DependencyInversion01 {
  public static void main(String[] args) {
    Person person = new Person();
    person.receive(new Email());
    person.receive(new WeiXin());
  }
}

interface IReceiver {
  String getInfo();
}

class Email implements IReceiver {
  @Override
  public String getInfo() {
    return "获取到电子邮件了";
  }
}

class WeiXin implements IReceiver {
  @Override
  public String getInfo() {
    return "获取到微信消息";
  }
}


// 完成 Person接收消息的功能
// 这里我们是对接口的依赖
class Person {
  public void receive(IReceiver receiver) {
    System.out.println(receiver.getInfo());
  }
}
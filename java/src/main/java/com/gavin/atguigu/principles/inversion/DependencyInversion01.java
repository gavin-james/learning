package com.gavin.atguigu.principles.inversion;

public class DependencyInversion01 {
  public static void main(String[] args) {
    Person person = new Person();
    person.receive(new Email());
  }
}


class Email {
  public String getInfo() {
    return "获取到电子邮件了";
  }
}
// 完成 Person接收消息的功能
// 方式 1 完成
// 1. 简单，比较容易想到
// 2. 如果我们获取的对象是微信，短信等等，则新增类，同事Person也要增加响应的接接收方法
// 3. 解决思路：引入一个抽象的接口IReceiver，标识接收者，这样Person类与接口IReceiver发生依赖
//  因为Email、WeiXin等等属于接收的范围，他们各自实现IReceiver接口就ok，这样我们就符合依赖倒转原则
class Person {
  public void receive(Email email) {
    System.out.println(email.getInfo());
  }
}
package com.gavin.atguigu.pattern.facade;

public class Popcon {

  private static Popcon instance = new Popcon();

  private Popcon() {

  }

  public static Popcon getInstance() {
    return instance;
  }

  public void on() {
    System.out.println("pop on");
  }

  public void off() {
    System.out.println("pop  off");
  }

  public void pop() {
    System.out.println("pop is pop");
  }

  public void pause() {
    System.out.println("pop is pause");
  }
}

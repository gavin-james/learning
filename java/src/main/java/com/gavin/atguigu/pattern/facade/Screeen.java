package com.gavin.atguigu.pattern.facade;

public class Screeen {

  private static Screeen instance = new Screeen();

  private Screeen() {

  }

  public static Screeen getInstance() {
    return instance;
  }

  public void up() {
    System.out.println("Screeen up");
  }

  public void down() {
    System.out.println("Screeen  down");
  }

  public void on() {
    System.out.println("Screeen on");
  }
  public void off() {
    System.out.println("Screeen off");
  }
}

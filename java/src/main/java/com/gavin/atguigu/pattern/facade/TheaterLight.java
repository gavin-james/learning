package com.gavin.atguigu.pattern.facade;

public class TheaterLight {
  private static TheaterLight instance = new TheaterLight();

  private TheaterLight() {

  }

  public static TheaterLight getInstance() {
    return instance;
  }


  public void on() {
    System.out.println("TheaterLight on");
  }

  public void off() {
    System.out.println("TheaterLight  off");
  }

  public void dim() {
    System.out.println("TheaterLight  dim");
  }

  public void down() {
    System.out.println("TheaterLight  down");
  }
}

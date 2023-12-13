package com.gavin.atguigu.pattern.facade;

public class Projector {

  private static Projector instance = new Projector();

  private Projector() {

  }

  public static Projector getInstance() {
    return instance;
  }

  public void on() {
    System.out.println("Projector on");
  }

  public void off() {
    System.out.println("Projector  off");
  }

  public void play() {
    System.out.println("Projector is playing");
  }

  public void facus() {
    System.out.println("Projector is facus");
  }
}

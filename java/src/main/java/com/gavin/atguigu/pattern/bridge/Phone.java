package com.gavin.atguigu.pattern.bridge;

public abstract class Phone {
  private Brand brand;

  public Phone(Brand brand) {
    this.brand = brand;
  }

  protected void open() {
    brand.open();
  }

  protected void close() {
    brand.close();
  }

  protected void call() {
    brand.call();
  }
}

package com.gavin.atguigu.pattern.bridge;

public class UpRightPhone extends Phone {

  public UpRightPhone(Brand brand) {
    super(brand);
  }

  @Override
  protected void open() {
    super.open();
    System.out.println(" 翻盖手机 ");
  }

  @Override
  protected void close() {
    super.close();
    System.out.println(" 翻盖手机 ");
  }

  @Override
  protected void call() {
    super.call();
    System.out.println(" 翻盖手机 ");
  }
}

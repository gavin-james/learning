package com.gavin.atguigu.pattern.bridge;

public class FoldedPhone extends Phone {
  public FoldedPhone(Brand brand) {
    super(brand);
  }

  @Override
  protected void open() {
    super.open();
    System.out.println(" 折叠手机 ");
  }

  @Override
  protected void close() {
    super.close();
    System.out.println(" 折叠手机 ");
  }

  @Override
  protected void call() {
    super.call();
    System.out.println(" 折叠手机 ");
  }
}

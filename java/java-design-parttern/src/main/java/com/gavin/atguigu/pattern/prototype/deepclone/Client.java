package com.gavin.atguigu.pattern.prototype.deepclone;

public class Client {
  public static void main(String[] args) throws CloneNotSupportedException {
    DeepCloneableTarget deepCloneableTarget = new DeepCloneableTarget("宋江", "水浒");

    DeepProptotype deepProptotype = new DeepProptotype("四大名著", deepCloneableTarget);
    DeepProptotype deepProptotype2 = (DeepProptotype) deepProptotype.deepClone();
    System.out.println(deepProptotype2);
    System.out.println(deepProptotype2.getDeepCloneableTarget());
    System.out.println(deepProptotype2.getDeepCloneableTarget()==deepCloneableTarget);
    System.out.println(deepProptotype2==deepProptotype);


  }
}

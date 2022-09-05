package com.gavin.atguigu.pattern.prototype.deepclone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeepProptotype implements Serializable, Cloneable {

  private String name;
  private DeepCloneableTarget deepCloneableTarget;

  // 深拷贝 - 方式一 使用 clone 方式
  @Override
  protected Object clone() throws CloneNotSupportedException {
    DeepProptotype deepProptotype = null;
    deepProptotype = (DeepProptotype) super.clone();
    deepProptotype.setDeepCloneableTarget((DeepCloneableTarget) deepCloneableTarget.clone());
    return deepProptotype;
  }

  // 深拷贝 - 方式二 使用对象的序列化方式（推荐）
  public Object deepClone() {
    // 创建对象流
    ByteArrayOutputStream bao;
    try {
      bao = new ByteArrayOutputStream();
      new ObjectOutputStream(bao).writeObject(this);
      return new ObjectInputStream(new ByteArrayInputStream(bao.toByteArray())).readObject();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}

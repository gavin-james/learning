package com.gavin.atguigu.pattern.prototype.deepclone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeepCloneableTarget implements Serializable,Cloneable {

  private String cloneName;
  private String cloneClass;

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}

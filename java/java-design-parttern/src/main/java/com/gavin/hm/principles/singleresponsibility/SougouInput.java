package com.gavin.hm.principles.singleresponsibility;

import lombok.Setter;

/**
 * @author Gavin
 * @ClassName SougouInput
 * @Description TODO
 * @date 2022/1/23 2:34
 * @Version 0.0.1
 */
@Setter
public class SougouInput {
  private AbstractSkin skin;

  public void display() {
    skin.display();
  }
}

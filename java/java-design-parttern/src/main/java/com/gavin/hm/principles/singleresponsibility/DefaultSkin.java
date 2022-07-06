package com.gavin.hm.principles.singleresponsibility;

import lombok.extern.java.Log;

/**
 * @author Gavin
 * @ClassName DefaultSkin
 * @Description 默认皮肤
 * @date 2022/1/23 2:20
 * @Version 0.0.1
 */
@Log
public class DefaultSkin extends AbstractSkin {
  /**
   * 部署皮肤
   */
  @Override
  public void display() {
    log.info("this is default skin");
  }
}

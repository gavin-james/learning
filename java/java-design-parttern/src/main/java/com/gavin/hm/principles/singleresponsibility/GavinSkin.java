package com.gavin.hm.principles.singleresponsibility;

import lombok.extern.java.Log;

/**
 * @author Gavin
 * @ClassName GavinSkin
 * @Description Gavin的专属皮肤
 * @date 2022/1/23 2:32
 * @Version 0.0.1
 */
@Log
public class GavinSkin extends AbstractSkin {
  /**
   * 部署皮肤
   */
  @Override
  public void display() {
    log.info("this is gavin skin");
  }
}

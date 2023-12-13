package com.gavin.hm.principles.singleresponsibility;

/**
 * @author Gavin
 * @ClassName Client
 * @Description 测试类
 * @date 2022/1/23 2:33
 * @Version 0.0.1
 */
public class Client {
  public static void main(String[] args) {
    // 1 创建搜狗输入法对象
    SougouInput sougouInput = new SougouInput();
    // 2.创建默认皮肤
    DefaultSkin defaultSkin = new DefaultSkin();
    // 3.设置皮肤
    sougouInput.setSkin(defaultSkin);
    // 4.部署皮肤
    sougouInput.display();
  }
}

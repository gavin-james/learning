package com.gavin.atguigu.pattern.flyweight;

import java.util.HashMap;

/**
 * 网站工厂类，根据需要，返回一个网站
 */
public class WebSiteFactory {

  /**
   * 集合，充当池的作用
   */
  private HashMap<String,ConcreateWebSite> pool = new HashMap<>();

  /**
   * 根据网站的类型，返回一个网站，如果没有就创建一个网站，并放入到池中，并返回
   * @param type 类型
   * @return 网站
   */
  public WebSite getWebSiteCategory(String type){
    if (!pool.containsKey(type)){
      pool.put(type,new ConcreateWebSite(type));
    }
    return  pool.get(type);
  }

  /**
   * 获取网站分类的大小
   * @return 网站总数
   */
  public int getWebSiteCount(){
    return pool.size();
  }
}

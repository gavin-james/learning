package com.gavin.atguigu.pattern.flyweight;

public class Client {
  public static void main(String[] args) {
    // 创建一个工厂
    WebSiteFactory webSiteFactory = new WebSiteFactory();
    // 客户要一个⃣以新闻方式发布的网站
    WebSite webSite1 = webSiteFactory.getWebSiteCategory("新闻");
    webSite1.use();
    webSite1 = webSiteFactory.getWebSiteCategory("博客");
    webSite1.use();
    webSite1 = webSiteFactory.getWebSiteCategory("博客");
    webSite1.use();
    webSite1 = webSiteFactory.getWebSiteCategory("博客");
    webSite1.use();
    webSite1 = webSiteFactory.getWebSiteCategory("博客");
    webSite1.use();
    webSite1 = webSiteFactory.getWebSiteCategory("博客");
    webSite1.use();

    System.out.println("网站的总数："+webSiteFactory.getWebSiteCount());
  }
}

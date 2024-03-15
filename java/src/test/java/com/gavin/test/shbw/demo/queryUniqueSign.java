//package com.gavin.test.shbw.demo;
//
//import util.EncryptUtils;
//import util.HttpClientHelper;
//import util.Urls;
//
///**
// * 1.1	查询企业唯一标识
// * 描述：后续相关接口都需要使用该标识（只需要调用一次）
// */
//public class queryUniqueSign {
//
//    public static void main(String[] args) {
//        //报文
//        String param = "{\"nsrmc\":\"上海宝钢高新技术零部件有限公司\",\"nsrsbh\":\"91310113669424198J\"}";
//
//        param = EncryptUtils.encodeBase64String(param);
//        System.out.println("请求密文：" + param);
//
//        String res = HttpClientHelper.httpPostRequest(Urls.queryUniqueSign, param, "json");
//        System.err.println("接口返回数据：" + res);
//
//    }
//
//}

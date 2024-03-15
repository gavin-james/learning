//package com.gavin.test.shbw.demo;
//
//import util.EncryptUtils;
//import util.HttpClientHelper;
//import util.Urls;
//
///**
// * 2.8	发票查询-按请求流水号查询
// * 描述：单张发票开具结果查询
// */
//public class queryOrder {
//
//    public static void main(String[] args) {
//        //报文
//        String param = "{\"qyId\": \"企业id\",\"ddlsh\": \"订单流水号\"}";
//
//        param = EncryptUtils.encodeBase64String(param);
//        System.out.println("请求密文：" + param);
//
//        String res = HttpClientHelper.httpPostRequest(Urls.queryOrder, param, "json");
//        System.err.println("接口返回数据：" + res);
//
//    }
//}

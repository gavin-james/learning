//package com.gavin.test.shbw.demo;
//
//import util.EncryptUtils;
//import util.HttpClientHelper;
//import util.Urls;
//
///**
// * 3.7 红字信息表申请结果查询（税控）
// * 描述：税控专票使用
// */
//public class queryHzxx {
//
//    public static void main(String[] args) {
//        //报文
//        String param = "{\"qyId\": \"企业唯一标识\",\"ddlsh\": \"红字申请订单流水号\"}";
//
//        param = EncryptUtils.encodeBase64String(param);
//        System.out.println("请求密文：" + param);
//
//        String res = HttpClientHelper.httpPostRequest(Urls.queryHzxx, param, "json");
//        System.err.println("接口返回数据：" + res);
//
//    }
//
//}

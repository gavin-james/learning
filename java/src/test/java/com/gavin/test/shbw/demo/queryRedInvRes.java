//package com.gavin.test.shbw.demo;
//
////import util.EncryptUtils;
//
///**
// * 3.4	数电红冲结果查询
// */
//public class queryRedInvRes {
//
//    public static void main(String[] args) {
//        //报文
//        String param = "{\n" +
//                "\t\"qyId\": \"企业唯一标识\",\n" +
//                "\t\"ddlsh\": \"红字申请订单流水号\",\n" +
//                "\t\"dlzh\": \"电局登录账号\",\n" +
//                "\t\"zjhm\": \"证件号码\"\n" +
//                "}";
//
//        param = EncryptUtils.encodeBase64String(param);
//        System.out.println("请求密文：" + param);
//
////        String res = HttpClientHelper.httpPostRequest(Urls.queryRedInvRes, param, "json");
//        System.err.println("接口返回数据：" + res);
//    }
//
//}

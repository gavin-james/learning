//package com.gavin.test.shbw.demo;
//
//import util.EncryptUtils;
//import util.HttpClientHelper;
//import util.Urls;
//
///**
// * 5.1	订单码（自助扫码开票）
// * 描述：向共享平台接口推送订单数据，平台返回自助开票的链接地址
// */
//public class addReceiptUrl {
//
//    public static void main(String[] args) {
//        //报文
//        String param = "{\n" +
//                "\t\"qyId\": \"企业唯一标识\",\n" +
//                "\t\"ddlsh\": \"订单流水号(全局唯一)\",\n" +
//                "\t\"sksbh\": \"税控设备号\",\n" +
//                "\t\"xsfMc\": \"销售方名称\",\n" +
//                "\t\"xsfNsrsbh\": \"销售方纳税人识别号\",\n" +
//                "\t\"xsfDzdh\": \"【税控必填】销售方地址电话\",\n" +
//                "\t\"xsfYhzh\": \"【税控必填】销售方银行账户\",\n" +
//                "\t\"kpr\": \"开票人\",\n" +
//                "\t\"skr\": \"收款人\",\n" +
//                "\t\"fhr\": \"复核人\",\n" +
//                "\t\"jshj\": \"价税合计\",\n" +
//                "\t\"hjje\": \"合计金额\",\n" +
//                "\t\"hjse\": \"合计税额\",\n" +
//                "\t\"bz\": \"备注\",\n" +
//                "\t\"sqr\": \"申请人\",\n" +
//                "\t\"fplxdm\": \"发票类型代码\",\n" +
//                "\t\"xsfDz\": \"【数电必填】销售方地址\",\n" +
//                "\t\"xsfDh\": \"【数电必填】销售方电话\",\n" +
//                "\t\"xsfYh\": \"【数电必填】销售方银行\",\n" +
//                "\t\"xsfZh\": \"【数电必填】销售方账户\",\n" +
//                "\t\"dlzh\": \"电局登录账号\",\n" +
//                "\t\"spxxbcsm\": \"商品信息补充说明\",\n" +
//                //商品明细
//                "\t\"prodParam\": [\n" +
//                "\t\t{\n" +
//                "\t\t\t\"spmc\": \"商品名称\",\n" +
//                "\t\t\t\"spbm\": \"商品编码\",\n" +
//                "\t\t\t\"ggxh\": \"规格型号\",\n" +
//                "\t\t\t\"dw\": \"单位\",\n" +
//                "\t\t\t\"dj\": \"含税单价\",\n" +
//                "\t\t\t\"sl\": \"数量\",\n" +
//                "\t\t\t\"je\": \"含税金额\",\n" +
//                "\t\t\t\"se\": \"税额\",\n" +
//                "\t\t\t\"slv\": \"税率，小数\",\n" +
//                "\t\t\t\"lslbs\": \"零税率标识\",\n" +
//                "\t\t\t\"yhzcbs\": \"优化政策标识\",\n" +
//                "\t\t\t\"zxbm\": \"自行编码\",\n" +
//                "\t\t\t\"zzstsgl\": \"增值税特殊管理\"\n" +
//                "\t\t}\n" +
//                "\t]\n" +
//                "}";
//
//        param = EncryptUtils.encodeBase64String(param);
//        System.out.println("请求密文：" + param);
//
//        String res = HttpClientHelper.httpPostRequest(Urls.addReceiptUrl, param, "json");
//        System.err.println("接口返回数据：" + res);
//
//    }
//
//}

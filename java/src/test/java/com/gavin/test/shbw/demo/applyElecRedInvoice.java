//package com.gavin.test.shbw.demo;
//
//import util.EncryptUtils;
//import util.HttpClientHelper;
//import util.Urls;
//
///**
// * 3.3	数电红冲申请
// * 描述：数电专、普票红冲申请
// */
//public class applyElecRedInvoice {
//
//    public static void main(String[] args) {
//        //报文
//        String param = "{\n" +
//                "\t\"qyId\": \"企业唯一标识\",\n" +
//                "\t\"dlzh\": \"电局登录账号\",\n" +
//                "\t\"zjhm\": \"证件号码\",\n" +
//                "\t\"ddlsh\": \"订单流水号(全局唯一)\",\n" +
//                "\t\"sksbh\": \"税控设备号\",\n" +
//                "\t\"fplxdm\": \"发票类型代码\",\n" +
//                "\t\"tspz\": \"特殊票种\",\n" +
//                "\t\"zsfs\": \"征收方式\",\n" +
//                "\t\"qdbz\": \"清单标识\",\n" +
//                "\t\"xsfMc\": \"销售方名称\",\n" +
//                "\t\"xsfNsrsbh\": \"销售方纳税人识别号\",\n" +
//                "\t\"xsfDz\": \"销售方地址\",\n" +
//                "\t\"xsfDh\": \"销售方电话\",\n" +
//                "\t\"xsfYh\": \"销售方银行\",\n" +
//                "\t\"xsfZh\": \"销售方账户\",\n" +
//                "\t\"gmfMc\": \"购买方名称\",\n" +
//                "\t\"gmfNsrsbh\": \"购买方纳税人识别号\",\n" +
//                "\t\"gmfDz\": \"购买方地址\",\n" +
//                "\t\"gmfDh\": \"购买方电话\",\n" +
//                "\t\"gmfYh\": \"购买方银行\",\n" +
//                "\t\"gmfZh\": \"购买方账户\",\n" +
//                "\t\"gmfMobile\": \"购买方手机号\",\n" +
//                "\t\"gmfEmail\": \"购买方邮箱\",\n" +
//                "\t\"jshj\": \"价税合计\",\n" +
//                "\t\"hjje\": \"合计金额\",\n" +
//                "\t\"hjse\": \"合计税额\",\n" +
//                "\t\"bz\": \"备注\",\n" +
//                "\t\"kce\": \"扣除额\",\n" +
//                "\t\"sqr\": \"申请人\",\n" +
//                "\t\"sslkjly\": \"小规模开具1%、3%发票理由\",\n" +
//                "\t\"sfwzzfp\": \"是否为纸质发票 Y是 N不是\",\n" +
//                "\t\"yfpDm\": \"原发票代码\",\n" +
//                "\t\"yfpHm\": \"原发票号码\",\n" +
//                "\t\"ykprq\": \"原开票日期\",\n" +
//                "\t\"yfplxdm\": \"原发票类型\",\n" +
//                "\t\"chyydm\": \"冲红原因代码\",\n" +
//                "\t\"jshjdx\": \"价税合计中文\",\n" +
//                "\t\"cloudData\": \"是否使用云票数据 0否 1是 \",\n" +
//                "\t\"ywdjDm\": \"【回调必填】业务单据代码\",\n" +
//                "\t\"detailParam\": [\n" +
//                "\t\t{\n" +
//                "\t\t\t\"xh\": \"序号\",\n" +
//                "\t\t\t\"lzmxxh\": \"蓝字明细序号\",\n" +
//                "\t\t\t\"fphxz\": \"发票行性质\",\n" +
//                "\t\t\t\"hsbz\": \"含税标识\",\n" +
//                "\t\t\t\"spmc\": \"商品名称\",\n" +
//                "\t\t\t\"spbm\": \"商品编码\",\n" +
//                "\t\t\t\"ggxh\": \"规格型号\",\n" +
//                "\t\t\t\"dw\": \"单位\",\n" +
//                "\t\t\t\"dj\": \"单价\",\n" +
//                "\t\t\t\"sl\": \"数量\",\n" +
//                "\t\t\t\"je\": \"金额\",\n" +
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
//        String res = HttpClientHelper.httpPostRequest(Urls.applyElecRedInvoice, param, "json");
//        System.err.println("接口返回数据：" + res);
//
//    }
//
//}

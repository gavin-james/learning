//package com.gavin.test.shbw.demo;
//
//import util.EncryptUtils;
//import util.HttpClientHelper;
//import util.Urls;
//
///**
// * 3.6 红字信息表申请（税控）
// * 描述：税控专票使用
// */
//public class uploadHzxx {
//
//    public static void main(String[] args) {
//        //报文
//        String param = "{\n" +
//                "\t\"ddlsh\": \"红字申请流水号(全局唯一)\",\n" +
//                "\t\"amount\": \"合计金额\",\n" +
//                "\t\"billtype\": \"0：正常（默认）；1：逾期\",\n" +
//                "\t\"buyername\": \"购方名称\",\n" +
//                "\t\"buytaxcode\": \"购方识别号\",\n" +
//                "\t\"fplxdm\": \"发票类型代码\",\n" +
//                "\t\"invno\": \"蓝票号码\",\n" +
//                "\t\"ismutirate\": \"0：一票一税率； 1：一票多税率（默认）\",\n" +
//                "\t\"jshj\": \"价税合计\",\n" +
//                "\t\"kpjh\": \"开票机号\",\n" +
//                "\t\"kprq\": \"蓝票开具日期YYYYMM\",\n" +
//                "\t\"lxdh\": \"联系电话\",\n" +
//                "\t\"qdbz\": \"清单标志 0 非清单 1 清单\",\n" +
//                "\t\"reqmemo\": \"申请说明：0 购方发起-已抵扣；1 购方发起-未抵扣；2 销方发起-开票有误\",\n" +
//                "\t\"reqnsrsbh\": \"纳税人识别号\",\n" +
//                "\t\"sellername\": \"销方名称\",\n" +
//                "\t\"selltaxcode\": \"销方识别号\",\n" +
//                "\t\"skpbh\": \"税控设备号\",\n" +
//                "\t\"slbz\": \"税率标志\",\n" +
//                "\t\"sqsy\": \"申请事由\",\n" +
//                "\t\"tax\": \"税额\",\n" +
//                "\t\"taxrate\": \"税率\",\n" +
//                "\t\"typecode\": \"蓝票代码\",\n" +
//                "\t\"fpxxHcsqMx\": [\n" +
//                "\t\t{\n" +
//                "\t\t\t\"dj\": \"含税单价,小数点后6位\",\n" +
//                "\t\t\t\"dw\": \"计量单位\",\n" +
//                "\t\t\t\"ggxh\": \"规格型号\",\n" +
//                "\t\t\t\"hsbz\": \"含税标志,N:不含税,Y:含税\",\n" +
//                "\t\t\t\"je\": \"含税金额,单位:元(2 位小数)\",\n" +
//                "\t\t\t\"lslbs\": \"零税率标识\",\n" +
//                "\t\t\t\"se\": \"税额,单位:元(2 位小数)\",\n" +
//                "\t\t\t\"sl\": \"商品数量,小数点后6位\",\n" +
//                "\t\t\t\"slv\": \"税率,SL 税率,6 位小数,例1%为0.01\",\n" +
//                "\t\t\t\"spbm\": \"商品编码该项在使用商品编码版本时必填\",\n" +
//                "\t\t\t\"spmc\": \"商品名称\",\n" +
//                "\t\t\t\"yhzcbs\": \"优惠政策标识,0:不使用,1:使用\",\n" +
//                "\t\t\t\"zxbm\": \"纳税人自行编码\",\n" +
//                "\t\t\t\"zzstsgl\": \"增值税特殊管理,如果yhzcbs为1时，此项必填\"\n" +
//                "\t\t}\n" +
//                "\t]\n" +
//                "}";
//
//        param = EncryptUtils.encodeBase64String(param);
//        System.out.println("请求密文：" + param);
//
//        String res = HttpClientHelper.httpPostRequest(Urls.uploadHzxx, param, "json");
//        System.err.println("接口返回数据：" + res);
//
//    }
//
//}

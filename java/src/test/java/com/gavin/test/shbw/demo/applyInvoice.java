//package com.gavin.test.shbw.demo;
//
//import util.EncryptUtils;
//import util.HttpClientHelper;
//import util.Urls;
//
///**
// * 2.7	发票开具申请
// * 描述：
// * 1、数电、税控蓝票开具
// * 2、税控红字发票开具
// */
//public class applyInvoice {
//
//    public static void main(String[] args) {
//        //报文
//        String param = "{\n" +
//                "\t\"qyId\": \"企业唯一标识\",\n" +
//                "\t\"ddlsh\": \"订单流水号(全局唯一)\",\n" +
//                "\t\"sksbh\": \"税控设备号、开票终端代码\",\n" +
//                "\t\"bmbBbh\": \"编码表版本号\",\n" +
//                "\t\"fplxdm\": \"发票类型代码\",\n" +
//                "\t\"kplx\": \"开票类型【0蓝字发票；1红字发票】\",\n" +
//                "\t\"fpDm\": \"发票代码\",\n" +
//                "\t\"fpHm\": \"发票号码\",\n" +
//                "\t\"tspz\": \"特殊票种\",\n" +
//                "\t\"zsfs\": \"征收方式\",\n" +
//                "\t\"qdbz\": \"清单标识\",\n" +
//                "\t\"xsfMc\": \"销售方名称\",\n" +
//                "\t\"xsfNsrsbh\": \"销售方纳税人识别号\",\n" +
//                "\t\"xsfDzdh\": \"销售方地址、电话\",\n" +
//                "\t\"xsfYhzh\": \"销售方银行、账户\",\n" +
//                "\t\"gmfMc\": \"购买方名称\",\n" +
//                "\t\"gmfNsrsbh\": \"购买方纳税人识别号\",\n" +
//                "\t\"gmfDzdh\": \"购买方地址、电话\",\n" +
//                "\t\"gmfYhzh\": \"购买方银行、账户\",\n" +
//                "\t\"gmfMobile\": \"购买方手机号\",\n" +
//                "\t\"gmfEmail\": \"购买方邮箱\",\n" +
//                "\t\"kpr\": \"开票人\",\n" +
//                "\t\"skr\": \"收款人\",\n" +
//                "\t\"fhr\": \"复核人\",\n" +
//                "\t\"jshj\": \"价税合计\",\n" +
//                "\t\"hjje\": \"合计金额\",\n" +
//                "\t\"hjse\": \"合计税额\",\n" +
//                "\t\"bz\": \"备注\",\n" +
//                "\t\"yfpDm\": \"【红冲必填】原发票代码\",\n" +
//                "\t\"yfpHm\": \"【红冲必填】原发票号码\",\n" +
//                "\t\"tzdbh\": \"【税控专票红冲必填】通知单编号\",\n" +
//                "\t\"kce\": \"扣除额\",\n" +
//                "\t\"sqr\": \"申请人\",\n" +
//                "\t\"sslkjly\": \"小规模开具1%、3%发票理由\",\n" +
//                "\t\"ykprq\": \"【红冲必填】原开票日期\",\n" +
//                "\t\"yfplx\": \"【红冲必填】原发票类型\",\n" +
//                "\t\"chyydm\": \"冲红原因代码\",\n" +
//                "\t\"checkAudit\": \"是否自动审核\",\n" +
//                "\t\"dlzh\": \"电局登录账号\",\n" +
//                "\t\"zjhm\": \"证件号码\",\n" +
//                "\t\"sfwzzfp\": \"是否为纸质发票 Y是 N不是\",\n" +
//                "\t\"zpFppzdm\": \"发票票种代码\",\n" +
//                "\t\"gmfzrrbs\": \"自然人标识\",\n" +
//                "\t\"spflxconfirm\": \"事业单位标识\",\n" +
//                "\t\"sfzsgmfyhzh\": \"备注是否展示购方银行账户\",\n" +
//                "\t\"sfzsxsfyhzh\": \"备注是否展示销方银行账户\",\n" +
//                "\t\"ncpsgzjlx\": \"农产品证件类型\",\n" +
//                "\t\"cktslxDm\": \"出口退税类型代码\",\n" +
//                "\t\"cloudData\": \"【红冲节点】是否使用云票数据 0否 1是 \",\n" +
//                "\t\"ywdjDm\": \"【回调必填】业务单据代码\",\n" +
//                "\t\"sfdj\": \"【单据开票必填】是否单据\",\n" +
//                "\t\"djbh\": \"【单据开票必填】单据编号\",\n" +
//                "\t\"spxxbcsm\": \"商品信息补充说明\",\n" +
//                //商品明细
//                "\t\"detailParam\": [\n" +
//                "\t\t{\n" +
//                "\t\t\t\"xh\": \"序号\",\n" +
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
//                "\t],\n" +
//                //以下为特殊票种节点，未使用的可以不传
//                //差额票
//                "\t\"pzDetailParam\": [\n" +
//                "\t\t{\n" +
//                "\t\t\t\"bckcje\": \"本次扣除金额\",\n" +
//                "\t\t\t\"bz\": \"备注\",\n" +
//                "\t\t\t\"fpdm\": \"发票代码\",\n" +
//                "\t\t\t\"fphm\": \"全电票发票号码\",\n" +
//                "\t\t\t\"kjrq\": \"开具日期\",\n" +
//                "\t\t\t\"pzhjje\": \"凭证合计金额\",\n" +
//                "\t\t\t\"pzhm\": \"凭证号码\",\n" +
//                "\t\t\t\"pzlx\": \"凭证类型\",\n" +
//                "\t\t\t\"zzfphm\": \"增值税发票号码\"\n" +
//                "\t\t}\n" +
//                "\t],\n" +
//                //货物运输服务
//                "\t\"hwysfwdzfpmxbList\": [\n" +
//                "\t\t{\n" +
//                "\t\t\t\"xh\": \"序号\",\n" +
//                "\t\t\t\"ysgjzl\": \"运输工具种类\",\n" +
//                "\t\t\t\"ysgjhp\": \"运输工具牌号\",\n" +
//                "\t\t\t\"qyd\": \"起运地\",\n" +
//                "\t\t\t\"ddd\": \"到达地\",\n" +
//                "\t\t\t\"yshwmc1\": \"运输货物名称\"\n" +
//                "\t\t}\n" +
//                "\t],\n" +
//                //建筑服务
//                "\t\"jzfwTdys\": {\n" +
//                "\t\t\"tdzzsxmbh\": \"土地增值税项目编号\",\n" +
//                "\t\t\"jzfwfsd\": \"建筑服务发生地\",\n" +
//                "\t\t\"fullAddress\": \"详细地址\",\n" +
//                "\t\t\"jzxmmc\": \"建筑项目名称\",\n" +
//                "\t\t\"kdsbz\": \"跨地市标识\"\n" +
//                "\t},\n" +
//                //不动产销售、租赁
//                "\t\"bdcTdys\": {\n" +
//                "\t\t\"bdcdz\": \"不动产地址（省、市、区/县）\",\n" +
//                "\t\t\"fullAddress\": \"不动产详细地址（街道/乡村、小区、门牌号）\",\n" +
//                "\t\t\"zlqqz\": \"租赁起止日期（格式：2022-03-10 2022-04-07）\",\n" +
//                "\t\t\"kdsbz\": \"跨地市标识\",\n" +
//                "\t\t\"cqzsh\": \"产权证书号\",\n" +
//                "\t\t\"dw\": \"单位\",\n" +
//                "\t\t\"wqhtbabh\": \"网签合同备案号\",\n" +
//                "\t\t\"tdzzsxmbh\": \"土地增值税项目编号\",\n" +
//                "\t\t\"hdjsjg\": \"核定计税价格\",\n" +
//                "\t\t\"sjcjhsje\": \"实际成交含税金额\"\n" +
//                "\t},\n" +
//                //旅客运输服务
//                "\t\"lkysfwTdysList\": [\n" +
//                "\t\t{\n" +
//                "\t\t\t\"xh\": \"序号\",\n" +
//                "\t\t\t\"cxr\": \"出行人\",\n" +
//                "\t\t\t\"chuxrq\": \"出现日期\",\n" +
//                "\t\t\t\"cxrzjlx\": \"出行人证件类型\",\n" +
//                "\t\t\t\"sfzjhm\": \"身份证件号码\",\n" +
//                "\t\t\t\"cfd\": \"出发地\",\n" +
//                "\t\t\t\"ddd\": \"到达地\",\n" +
//                "\t\t\t\"dengj\": \"等级\",\n" +
//                "\t\t\t\"jtgjlx\": \"交通工具类型\"\n" +
//                "\t\t}\n" +
//                "\t]\n" +
//                "}";
//
//        param = EncryptUtils.encodeBase64String(param);
//        System.out.println("请求密文：" + param);
//
//        String res = HttpClientHelper.httpPostRequest(Urls.applyInvoice, param, "json");
//        System.err.println("接口返回数据：" + res);
//
//    }
//
//}

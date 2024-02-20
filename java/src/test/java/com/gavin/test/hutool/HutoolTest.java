package com.gavin.test.hutool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.net.url.UrlQuery;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.webservice.SoapClient;
import cn.hutool.json.JSONUtil;
import com.gavin.test.playwright.ReqEntity;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HutoolTest {
    @Test
    void sapTest() {
        SoapClient arg0 = SoapClient.create("fsfafs")
                // 设置要请求的方法，此接口方法前缀为web，传入对应的命名空间
                .setMethod("tns:ZFI_SDFP_FILL_RESULT", "urn:sap-com:document:sap:rfc:functions").setParam("arg0", "<![CDATA[" + "fasfa" + "]]>", false);
        System.out.println(arg0.getMsgStr(true));
    }

    @Test
    void resourceTest() {
        String path = "test.json";
        URL resource = ClassUtil.getClassLoader().getResource(path);
        System.out.println(resource.getPath());
    }

    @Test
    void httpUtilTest() {
        String url = "https://xz.bwfapiao.com/50012345671180277/011000020026/011000020026_15726112.pdf?Expires=2003307745&OSSAccessKeyId=LTAIB3SkRb2V8Vu1&Signature=q9aZ3B3w2DTKD37U5aXyKWyzsbo%3D";
        byte[] bytes = HttpUtil.downloadBytes(url);
        System.out.println(bytes.length);
    }

    @Test
    void urlUtilTest() {
        String fileUrl = "https://dppt.shanghai.chinatax.gov.cn:8443/kpfw/fpjfzz/v1/exportDzfpwjEwm?Wjgs=PDF&Jym=522C&Fphm=23312000000079149234&Kprq=20230915140931&Czsj=1694758173603";
        System.out.println();
        UrlQuery urlQuery = UrlQuery.of(StrUtil.subAfter(fileUrl, '?', true), StandardCharsets.UTF_8);
        CharSequence fphm = urlQuery.get("Fphm");
        System.out.println(fphm);
//        System.out.println(url);
    }

    @Test
    void getOrganization() {
        String url = "http://app.gjzwfw.gov.cn/jimps/link.do";
        ReqEntity reqEntity = new ReqEntity();
        reqEntity.setDljzProvince("");
        reqEntity.setDlzjNo("");
        reqEntity.setDlzjName("");
        reqEntity.setDljzOrgType("");
        reqEntity.setCurrentPage(1);
        reqEntity.setPageSize(6);
        reqEntity.setFrom("1");
        reqEntity.setKey("74165095eeb0433db02c1b58ac57c642");
        String requestTime = String.valueOf(DateUtil.current());
        String sign = MD5.create().digestHex("dljzjgcx" + requestTime);
        reqEntity.setRequestTime(requestTime);
        reqEntity.setSign(sign);
        String jsonStr = JSONUtil.toJsonStr(reqEntity);

        System.out.println(jsonStr);
//        HttpRequest post = HttpUtil.createPost(url)
//                .form("param", jsonStr);
//        post.contentType("application/x-www-form-urlencoded; charset=UTF-8");
//        HttpResponse execute = post.execute();
//        System.out.println(execute.headers());
//        System.out.println(execute.body());
    }

    @Test
    void timeTest() {
        String qdpkpzd = "91310104057643445Y_QD";
        for (int i = 0; i < 50; i++) {
            if (i < 10) {
//                System.out.print(qdpkpzd + "0" + i + ",");
                System.out.println("INSERT INTO `swgxpt_test`.`swgx_jb_kpdxx` (`kpddm`, `kpdmc`, `yhzh`, `dzdh`, `fplxdm`, `nsrsbh`, `skr`, `fhr`, `deleted`, `kpr`, `dzpbz`, `mrkpzd`, `jqbh`, `type`, `login_type`, `zdzh`, `zdmm`, `phone`, `idno`, `zddz`, `tdyw`, `pzsbh`, `zhlx`, `last_verify_time`, `xfyhzh`, `xfdh`, `zpfwUrl`, `zpfw_url`, `zrrdlmm`, `dljslx`, `dljsmm`, `sfkqzpfw`, `bind_zpfw_success_status`, `kqht`, `kpms`, `time_interval`, `qqlsh`, `sfsl`, `sxlb`, `yjjb`, `credit_expire_msg_status`, `dllx`, `verify_result`, `ewmlx`, `dzswjdllx`, `dzswjdlfs`, `certurl`, `sksblx`, `sksbbh`, `sksbmm`, `jklx`, `smsuploadtype`, `last_login_time`, `qywx_user`, `qywx_user1`) VALUES ('" + qdpkpzd + "0" + i + "', '数电发票-测试使用', '上海', '1', '01,02', '91310104057643445Y', '', '', '0', '测试使用', NULL, 1, '0', '1', NULL, '12345678', '12345678', '17633737534', '12345678', NULL, '03', '12345678', NULL, NULL, '12345678', '1', NULL, NULL, NULL, '5', '12345678', 0, NULL, NULL, '1', 24, NULL, '', '', '', 0, NULL, NULL, '1', '0', 'A1', '', '', '', '', '1', '1', NULL, 'XuHongQiang', NULL);");

            } else {
//                System.out.print(qdpkpzd + i + ",");
                System.out.println("INSERT INTO `swgxpt_test`.`swgx_jb_kpdxx` (`kpddm`, `kpdmc`, `yhzh`, `dzdh`, `fplxdm`, `nsrsbh`, `skr`, `fhr`, `deleted`, `kpr`, `dzpbz`, `mrkpzd`, `jqbh`, `type`, `login_type`, `zdzh`, `zdmm`, `phone`, `idno`, `zddz`, `tdyw`, `pzsbh`, `zhlx`, `last_verify_time`, `xfyhzh`, `xfdh`, `zpfwUrl`, `zpfw_url`, `zrrdlmm`, `dljslx`, `dljsmm`, `sfkqzpfw`, `bind_zpfw_success_status`, `kqht`, `kpms`, `time_interval`, `qqlsh`, `sfsl`, `sxlb`, `yjjb`, `credit_expire_msg_status`, `dllx`, `verify_result`, `ewmlx`, `dzswjdllx`, `dzswjdlfs`, `certurl`, `sksblx`, `sksbbh`, `sksbmm`, `jklx`, `smsuploadtype`, `last_login_time`, `qywx_user`, `qywx_user1`) VALUES ('" + qdpkpzd + i + "', '数电发票-测试使用', '上海', '1', '01,02', '91310104057643445Y', '', '', '0', '测试使用', NULL, 1, '0', '1', NULL, '12345678', '12345678', '17633737534', '12345678', NULL, '03', '12345678', NULL, NULL, '12345678', '1', NULL, NULL, NULL, '5', '12345678', 0, NULL, NULL, '1', 24, NULL, '', '', '', 0, NULL, NULL, '1', '0', 'A1', '', '', '', '', '1', '1', NULL, 'XuHongQiang', NULL);");

            }

        }

    }

    @Test
    void xmlTest() {
//        System.out.println(EscapeUtil.escapeXml("<!DOCTYPE html><html><head>电局页面信息</head><body></html>"));
        System.out.println(DateUtil.currentSeconds());
    }
}

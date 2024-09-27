package com.gavin.test.hutool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.net.url.UrlQuery;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.webservice.SoapClient;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.gavin.test.playwright.ReqEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HutoolTest {
    @Test
    void sapTest() {
        SoapClient arg0 = SoapClient.create("http://WYPRD.com:8000/sap/bc/srt/wsdl/srvc_814E1B22FAD31EDE8F93C341713A8C0D/wsdl11/allinone/ws_policy/document?sap-client=800")
                // 设置要请求的方法，此接口方法前缀为web，传入对应的命名空间
                .setMethod("MT_BW2ECC_INVOICE_REQ", "urn:sap-com:document:sap:rfc:functions").setParam("djbh", "12234567", false).setParam("qdfphm", "12234567", false);
        System.out.println(arg0.getMsgStr(true));
    }


    @Test
    void sap2Test() {
        SoapClient arg0 = SoapClient.create("http://piqas.luolai.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=BW&receiverParty=&receiverService=&interface=SI_BW2ECC_INVOICE_OUT&interfaceNamespace=http%3A%2F%2Fluolai.com%2Fbaiwang\n").header("Authorization", "Basic UElRX0JXUzpGV2l1ZGw4Sm5o")
                // 设置要请求的方法，此接口方法前缀为web，传入对应的命名空间
                .setMethod("n0:MT_BW2ECC_INVOICE_REQ", "http://luolai.com/baiwang").setParam("djbh", "12234567", false).setParam("qdfphm", "12234567", false);
//
        System.out.println(arg0.getMsgStr(true));
        String send = arg0.send();
//        System.out.println(send);
    }

    @Test
    void resourceTest() {
//        String path = "test.json";
//        URL resource = ClassUtil.getClassLoader().getResource(path);
//        System.out.println(resource.getPath());
//        System.out.println("2");
        HttpRequest post1 = HttpRequest.post("www.baidu.com");
        HttpResponse test = post1.body("test").executeAsync();
        System.out.println(test.body());
        System.out.println("1");

        System.out.println(test.body());
    }

    @Test
    void httpUtilTest() {
//        String url = "https://xz.bwfapiao.com/50012345671180277/011000020026/011000020026_15726112.pdf?Expires=2003307745&OSSAccessKeyId=LTAIB3SkRb2V8Vu1&Signature=q9aZ3B3w2DTKD37U5aXyKWyzsbo%3D";
//        byte[] bytes = HttpUtil.downloadBytes(url);
//        System.out.println(bytes.length);
        BigDecimal a1 = new BigDecimal("10562.78");
        BigDecimal a2 = new BigDecimal("1.05");
        System.out.println(a1.divide(a2, 10, BigDecimal.ROUND_HALF_UP));

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


    @Test
    void jsonTest() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "\nfjaijsfa");
        System.out.println(JSONUtil.toJsonStr(map));
        System.out.println();

        String json = (String) JSON.toJSON(map);
        System.out.println(JSON.parse(json));
//        System.out.println(resource.getPath());

    }

    @Test
    void xml2Test() {
        String sendStr = "<SOAP:Envelope\n" + "    xmlns:SOAP='http://schemas.xmlsoap.org/soap/envelope/'>\n" + "    <SOAP:Header/>\n" + "    <SOAP:Body>\n" + "        <n0:MT_BW2ECC_INVOICE_RES\n" + "            xmlns:n0='http://luolai.com/baiwang'\n" + "            xmlns:prx='urn:sap.com:proxy:EQ1:/1SAI/TAS07D64D71D48E572BB400:701:2009/02/10'>\n" + "            <flag>S</flag>\n" + "            <msg>更新成功</msg>\n" + "        </n0:MT_BW2ECC_INVOICE_RES>\n" + "    </SOAP:Body>\n" + "</SOAP:Envelope>";
        Map<String, Object> stringObjectMap = XmlUtil.xmlToMap(sendStr);
        System.out.println(stringObjectMap);
        String flag = (String) ((Map<String, Object>) ((Map<String, Object>) stringObjectMap.get("SOAP:Body")).get("n0:MT_BW2ECC_INVOICE_RES")).get("flag");
        System.out.println(flag);
//        String flag = (String) ((Map<String, Object>) ((Map<String, Object>) stringObjectMap.get("soap:Body")).get("ns2:xfireResponse")).get("return");
//        System.out.println(flag);
    }

    @Test
    void mathTest() {
//        byte[] priBytes = FileUtil.readBytes("/Users/mac/Downloads/key/T4VbpEVQsUTlKxee.pri");
//        byte[] pubBytes = FileUtil.readBytes("/Users/mac/Downloads/key/T4VbpEVQsUTlKxee.pub");
//        AsymmetricCrypto(AsymmetricAlgorithm.);
////        System.out.println();
////        System.out.println();
//        RSA rsa = new RSA(Base64.encode(priBytes), Base64.encode(pubBytes));
//        byte[] encrypt = rsa.encrypt("test", KeyType.PublicKey);
//        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
//        System.out.println(StrUtil.str(encrypt, StandardCharsets.UTF_8));
//        System.out.println(StrUtil.str(decrypt, StandardCharsets.UTF_8));
//        AsymmetricCrypto asymmetricCrypto = new AsymmetricCrypto();
//        DSA dsa =new DSA() {
//        }
        String name = "浙江省温州市永嘉县双塔路和田工业园区";
        List<Map<String, String>> dzList = HutoolTest.addressResolution(name);
        System.out.println(dzList);
        String province = dzList.get(0).get("province");
        System.out.println(province);
    }

    public static List<Map<String, String>> addressResolution(String address) {
        //不动产坐落地址（省）：必须以省、自治区、特别行政区、北京市、天津市、上海市、重庆市任意一个关键词结尾。当红冲不动产坐落地址未修改为三个字段的蓝票时，如果蓝票不动产坐落地址没有填写省（直辖市、自治区、特别行政区），该字段可不填写。
        //不动产坐落地址（市）：必须以市、盟、自治州、地区、区任意一个关键词结尾。
        //不动产坐落地址（详细地址）：必须包含街、路、村、乡、镇、道、巷、号任意一个关键词。

        //String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        //String regex1="(?<province>[^省]+自治区|.*?省|.*?特别行政区|.*?北京市|.*?天津市|.*?上海市|.*?重庆市) ? (?<village>.*)";

        String regex = "(?<province>[^省]+自治区|.*?省|.*?特别行政区|.*?北京市|.*?天津市|.*?上海市|.*?重庆市)(?<city>[^市]+自治州|.*?地区|.*?区|.*?盟|.*?市)?(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";

        Matcher m = Pattern.compile(regex).matcher(address);
        String province = null, city = null, county = null, town = null, village = null;
        List<Map<String, String>> table = new ArrayList<Map<String, String>>();
        Map<String, String> row = null;
        while (m.find()) {
            row = new LinkedHashMap<String, String>();
            province = m.group("province");
            row.put("province", province == null ? "" : province.trim());
            city = m.group("city");
            row.put("city", city == null ? "" : city.trim());
            county = m.group("county");
            row.put("county", county == null ? "" : county.trim());
            town = m.group("town");
            row.put("town", town == null ? "" : town.trim());
            village = m.group("village");
            row.put("village", village == null ? "" : village.trim());
            table.add(row);
        }
        return table;
    }

    @Test
    void math2Test() {
        String str = "fasgadf";
        str.contains("a");
        str.replace("a", "d");
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "One");
//        map.put(2, "Two");
//        map.put(3, "Three");
//        for (int i = 0; i < 3; i++) {
//            continue;
//        }
//
//        map.forEach((key, value) -> {
//            System.out.println("Key: " + key + ", Value: " + value);
//            if (value == "Two") {
//                return;
//            }
//
//            System.out.println(value);
//            // 这里可以执行你想要的操作
//        });
        System.out.println(new BigDecimal("438518.48").multiply(new BigDecimal(2)));
        System.out.println(new BigDecimal("417636.65").multiply(new BigDecimal(2)));
        System.out.println(new BigDecimal("20881.83").multiply(new BigDecimal(2)));
        System.out.println(new BigDecimal("-20881.83").compareTo(BigDecimal.ZERO));
//        List<String> tempStrList = new ArrayList<>();
//        tempStrList.add("12,3");
//        tempStrList.add("123");
//        tempStrList.add("123");
//        System.out.println(String.join(",", tempStrList));
    }

    @Test
    void xml3Test() {
        ArrayList<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
//        String htmlStr = ResourceUtils.getFileStr("test.html");
//        Document doc = Jsoup.parse(htmlStr);
//        Elements select = doc.select("input[id='ID']");
//        for (Element element : select) {
//            System.out.println(element.attr("rq"));
//            System.out.println(element.attr("value"));
//        }
//        System.out.println(select.size());


//        Elements select1 = doc.select("#JBDM");
//        System.out.println(select1.get(0).val());

//        System.out.println("10 * 10 = " + 10 * 10 + " \t10\t" + (double) 10 / (10 * 10));
//        System.out.println("16 * 16 = " + 16 * 16 + " \t40\t" + (double) 40 / (16 * 16));
//        System.out.println("30 * 16 = " + 30 * 16 + " \t99\t" + (double) 99 / (30 * 16));

        System.out.println("2024-01-01 2024-01-20".substring(0, 7));
    }
}

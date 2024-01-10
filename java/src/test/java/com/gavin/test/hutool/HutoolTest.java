package com.gavin.test.hutool;

import cn.hutool.core.net.url.UrlQuery;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.webservice.SoapClient;
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

}

package com.gavin.test.shbw.util;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName HttpClientHelper
 * @Description
 * @Author 35898
 * @Date 2019/5/25 10:25
 * @Version 1.0
 **/

public class HttpClientHelper {
    //正式环境accessKeyId
    private static final String accessKeyId = "0835b02b708c43598364266adae7fc1c";
    //正式环境accessKeySecre
    private static final String accessKeySecre = "d46885fae7cc43799e60a45d0bd448b8";

    private HttpClientHelper() {
    }

    public static String httpPostRequest(String url, String params, String ContentType) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            StringEntity entity = new StringEntity(params, "utf-8");
            httpPost.setEntity(entity);
            if ("json".equals(ContentType)) {
                httpPost.setHeader("Content-type", "application/json");
            } else {
                httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            }
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //网关密钥
            HtjsApiSdkClient hsc = new HtjsApiSdkClient(HttpClientHelper.accessKeyId, HttpClientHelper.accessKeySecre);

            Map header = hsc.get_signed_headers("POST", url);
            System.out.println("4、header数据：");

            Set keyset = header.keySet();
            Iterator it = keyset.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                httpPost.setHeader(key, (String) header.get(key));
                System.out.println("key值：" + key + "对应值：" + (String) header.get(key));
            }
            response = httpClient.execute(httpPost);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String result = "";
//        if (response.getStatusLine().getStatusCode() == 200) {
        try {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        }

        try {
            httpClient.close();
            response.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

}

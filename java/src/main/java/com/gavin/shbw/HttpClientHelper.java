package com.gavin.shbw;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static Logger log = LoggerFactory.getLogger(HttpClientHelper.class);

    private HttpClientHelper() {
    }

    public static String httpPostRequest(String url, String params) {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            StringEntity entity = new StringEntity(params, "UTF-8");
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            HtjsApiSdkClient hsc = new HtjsApiSdkClient("6sbC4g9LNbH9XbB3aDmZf619", "LsH6ZX6m8hkugCJ5IQt4Kj9Aqc476D");
            Map header = hsc.get_signed_headers("POST", url);
            Set keyset = header.keySet();
            Iterator it = keyset.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                httpPost.setHeader(key, (String) header.get(key));
            }

            response = httpClient.execute(httpPost);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = "";
        if (response.getStatusLine().getStatusCode() == 200) {
            try {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String httpGetRequest(String url) {

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpGet.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            HtjsApiSdkClient hsc = new HtjsApiSdkClient("6sbC4g9LNbH9XbB3aDmZf619", "LsH6ZX6m8hkugCJ5IQt4Kj9Aqc476D");
            Map header = hsc.get_signed_headers("get", url);
            Set keyset = header.keySet();
            Iterator it = keyset.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                httpGet.setHeader(key, (String) header.get(key));
            }

            response = httpClient.execute(httpGet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = "";
        if (response.getStatusLine().getStatusCode() == 200) {
            try {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {

            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String httpPostRequest(String url, String params, String ContentType) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            //  httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
            StringEntity entity = new StringEntity(params, "utf-8");
            httpPost.setEntity(entity);
            if ("json".equals(ContentType)) {
                httpPost.setHeader("Content-type", "application/json");
            } else {
                httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            }
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            HtjsApiSdkClient hsc = new HtjsApiSdkClient("2hJHrQU6329IIpVCwcWMXA6D", "oaTIG3Z8sAI5cpMYc4att2JEg1RBRv");

            Map header = hsc.get_signed_headers("POST", url);
            Set keyset = header.keySet();
            Iterator it = keyset.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                httpPost.setHeader(key, (String) header.get(key));
            }

            response = httpClient.execute(httpPost);
        } catch (Exception e) {
            HttpClientHelper.log.info("请求出错：" + e.getMessage());
        }
        String result = "";
        if (response.getStatusLine().getStatusCode() == 200) {
            try {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            } catch (IOException e) {
                HttpClientHelper.log.info("获取返回结果出错：" + e.getMessage());
            }
        } else {
            HttpClientHelper.log.info("请求服务器失败，错误代码：" + response.getStatusLine().getStatusCode());
        }

        try {
            httpClient.close();
            response.close();
        } catch (IOException e) {
            HttpClientHelper.log.info("关闭异常：" + e.getMessage());
        }

        return result;
    }

    /**
     * 税务共享新版SaaS使用
     *
     * @param url
     * @param params
     * @param ContentType
     * @param accessKeyId
     * @param accessKeySecret
     * @return
     */
    public static String nowSaaSPost(String url, String params, String ContentType, String accessKeyId, String accessKeySecret) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            //  httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
            StringEntity entity = new StringEntity(params, "utf-8");
            httpPost.setEntity(entity);
            if ("json".equals(ContentType)) {
                httpPost.setHeader("Content-type", "application/json");
            } else {
                httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            }
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            HtjsApiSdkClient hsc = new HtjsApiSdkClient(accessKeyId, accessKeySecret);

            Map header = hsc.get_signed_headers("POST", url);
            Set keyset = header.keySet();
            Iterator it = keyset.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                httpPost.setHeader(key, (String) header.get(key));
            }

            response = httpClient.execute(httpPost);
        } catch (Exception e) {
            HttpClientHelper.log.info("请求出错：" + e.getMessage());
        }
        String result = "";
        if (response.getStatusLine().getStatusCode() == 200) {
            try {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            } catch (IOException e) {
                HttpClientHelper.log.info("获取返回结果出错：" + e.getMessage());
            }
        } else {
            HttpClientHelper.log.info("请求服务器失败，错误代码：" + response.getStatusLine().getStatusCode());
        }

        try {
            httpClient.close();
            response.close();
        } catch (IOException e) {
            HttpClientHelper.log.info("关闭异常：" + e.getMessage());
        }

        return result;
    }

}

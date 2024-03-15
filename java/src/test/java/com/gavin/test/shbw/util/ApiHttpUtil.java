package com.gavin.test.shbw.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


/**
 * @author Ragdoll
 * @version 2019年5月23日 下午9:03:43
 */
public class ApiHttpUtil {


    private static final String UTF8 = "UTF-8";

    private ApiHttpUtil() {
    }

    public static String apiHttpGet(String path) {
        HttpURLConnection conn = null;
        InputStream is = null;
        try {
            HtjsApiSdkClient htjsApi = new HtjsApiSdkClient("78DRaVmt7UfhVCzUg5LYMv10", "Z4J3dEqFH70bFhHj6ozunT2xW03vyT");
            Map<String, String> headers = htjsApi.get_signed_headers("GET", path);
            URL url = new URL(path);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            for (Map.Entry<String, String> header : headers.entrySet()) {
                conn.setRequestProperty(header.getKey(), header.getValue());
            }
            conn.setRequestProperty("Accept", "*/*");
            conn.connect();

            is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            StringBuilder buffer = new StringBuilder();
            while ((str = br.readLine()) != null) {
                str = new String(str.getBytes(), ApiHttpUtil.UTF8);
                buffer.append(str);
            }
            is.close();
            conn.disconnect();
            return buffer.toString();
        } catch (Exception e) {

        } finally {
            if (conn != null) {
                conn.disconnect();
            }

        }
        return null;
    }

    public static String apiHttpPost(String path, String param) {
        String params = param == null ? "" : param;
        HttpURLConnection connection = null;
        try {
            HtjsApiSdkClient htjsApi = new HtjsApiSdkClient("78DRaVmt7UfhVCzUg5LYMv10", "Z4J3dEqFH70bFhHj6ozunT2xW03vyT");
            Map<String, String> headers = htjsApi.get_signed_headers("post", path);
            URL url = new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            //connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.connect();

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(params.getBytes(ApiHttpUtil.UTF8));
            out.flush();
            out.close();
            connection.getOutputStream().close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), ApiHttpUtil.UTF8));
            StringBuilder buffer = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            connection.getInputStream().close();
            connection.disconnect();
            return buffer.toString();
        } catch (Exception e) {

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

}

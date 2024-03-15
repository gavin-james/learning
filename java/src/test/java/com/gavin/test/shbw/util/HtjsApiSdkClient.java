package com.gavin.test.shbw.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Ragdoll
 * @version 2019年5月23日 下午8:30:32
 */
public final class HtjsApiSdkClient {
    private String accessKeyId;
    private String accessKeySecret;

    private static String[] enforeHeadersArr = {"host", "date", "x-htjs-ua", "x-htjs-nonce"};
    private static HashSet<String> enforeHeadersSet = new HashSet<>();

    static {
        Arrays.sort(HtjsApiSdkClient.enforeHeadersArr);
        for (String header : HtjsApiSdkClient.enforeHeadersArr) {
            HtjsApiSdkClient.enforeHeadersSet.add(header);
        }
    }

    public HtjsApiSdkClient(String accessKeyId, String accessKeySecret) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }

    static byte[] calcHmacSha256(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        return sha256_HMAC.doFinal(data.getBytes("UTF-8"));
    }

    static String calcBase64(byte[] data) {
        Base64.Encoder enc = Base64.getEncoder();
        String b64 = enc.encodeToString(data);
        return b64;
    }

    public Map<String, String> get_signed_headers(String method, String url, Map<String, String> headers, String httpVersion) throws HtjsApiSdkError {
        Map<String, String> headers_t = headers;

        headers = new HashMap<>();
        if (headers_t != null) {
            headers.putAll(headers_t);
        }

        method = method.toUpperCase();

        String host = null;
        String path = url;

        if (!url.startsWith("/")) {
            try {
                URL pr = new URL(url);
                host = (pr.getPort() >= 0) ? (pr.getHost() + ":" + pr.getPort()) : (pr.getHost());
                path = (pr.getQuery() != null && pr.getQuery().length() > 0) ? (pr.getPath() + "?" + pr.getQuery()) : pr.getPath();
            } catch (MalformedURLException e) {
                throw new HtjsApiSdkError("无效的url: " + url);
            }
        }

        HashMap<String, String> sign_headers = new HashMap<>();
        for (Map.Entry<String, String> entry : sign_headers.entrySet()) {
            String k = entry.getKey().toUpperCase();
            if (HtjsApiSdkClient.enforeHeadersSet.contains(k)) {
                sign_headers.put(k, entry.getValue());
            }
        }

        if ((!sign_headers.containsKey("host")) && (host != null && !host.isEmpty())) {
            headers.put("Host", host);
            sign_headers.put("host", host);
        }

        if (!sign_headers.containsKey("date")) {
            SimpleDateFormat fmt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
            fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
            String now = fmt.format(new Date());
            System.out.println("格林威治时间：" + now);
            headers.put("Date", now);
            sign_headers.put("date", now);
        }

        if (!sign_headers.containsKey("x-htjs-ua")) {
            String ua = String.format("Java %s %s bit, sdk-ver=1.0.0", System.getProperty("java.version"), System.getProperty("sun.arch.data.model"));
            headers.put("x-htjs-ua", ua);
            sign_headers.put("x-htjs-ua", ua);
        }

        if (!sign_headers.containsKey("x-htjs-nonce")) {
            String nonce = UUID.randomUUID().toString();
            headers.put("x-htjs-nonce", nonce);
            sign_headers.put("x-htjs-nonce", nonce);
        }

        StringBuilder sign_lines = new StringBuilder();
        sign_lines.append(String.format("%s %s HTTP/%s", method, path, httpVersion));
        for (String k : HtjsApiSdkClient.enforeHeadersArr) {
            if (sign_headers.containsKey(k)) {
                sign_lines.append("\n");
                sign_lines.append(String.format("%s: %s", k, sign_headers.get(k)));
            } else {
                throw new HtjsApiSdkError(String.format("缺少必要的HTTP请求头: %s", k));
            }
        }
        String sign_str = sign_lines.toString();
        System.out.println("1、待加密sign_str：\n" + sign_str);

        String ak_id = this.accessKeyId;
        String ak_secret = this.accessKeySecret;
        String sign;
        try {
            sign = HtjsApiSdkClient.calcBase64(HtjsApiSdkClient.calcHmacSha256(ak_secret, sign_str));
        } catch (Exception e) {
            throw new HtjsApiSdkError("计算HmacSha256失败");
        }
        System.out.println("2、生成sign：\n" + sign);

        StringBuilder auth_sb = new StringBuilder();
        auth_sb.append(String.format("hmac username=\"%s\"", ak_id));
        auth_sb.append(", ");
        auth_sb.append("algorithm=\"hmac-sha256\"");
        auth_sb.append(", ");
        auth_sb.append("headers=\"request-line");
        for (String header : HtjsApiSdkClient.enforeHeadersArr) {
            auth_sb.append(" ");
            auth_sb.append(header);
        }
        auth_sb.append("\", ");
        auth_sb.append(String.format("signature=\"%s\"", sign));

        String auth = auth_sb.toString();
        System.out.println("3、组装Authorization：\n" + auth);

        headers.put("Authorization", auth);
        return headers;
    }

    public Map<String, String> get_signed_headers(String method, String url, Map<String, String> headers) throws HtjsApiSdkError {
        return this.get_signed_headers(method, url, headers, "1.1");
    }

    public Map<String, String> get_signed_headers(String method, String url) throws HtjsApiSdkError {
        return this.get_signed_headers(method, url, null);
    }
}

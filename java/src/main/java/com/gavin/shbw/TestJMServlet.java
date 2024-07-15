//package com.gavin.shbw;
//
//import cn.hutool.core.codec.Base64;
//import com.bw.jxfp.client.AESutil;
//import com.bw.jxfp.client.Base64Coder;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.lang3.RandomStringUtils;
//
//import java.io.File;
//import java.net.URL;
//import java.net.URLConnection;
//import java.security.KeyFactory;
//import java.security.PrivateKey;
//import java.security.Signature;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
//
////税控服务器纸质发票servlet加密调用
//public class TestJMServlet {
//    public static String url = "http://test.shfapiao.cn/SKServer/SKDo";// 请求地址
//    public static String appid = "gAZ6PL5JL0Ih0dOm";// 由百旺提供的id
//    public static String aeskey = "JBh2clZ+3BJs+7VlQ8izrw==";// 由百旺提供的加解密密钥
//    public static String dqphcx = "E:/项目资料/S上海百旺/X销售部门/接口相关/税控服务器-sevlet调用/查询当前票号.txt";
//    public static String fpkj = "E:/项目资料/S上海百旺/X销售部门/接口相关/税控服务器-sevlet调用/纸质发票开具.txt";
//    public static String fpcx = "E:/项目资料/S上海百旺/X销售部门/接口相关/税控服务器-sevlet调用/纸质发票查询.txt";
//
//    /**
//     * 对报文进行签名计算
//     *
//     * @param timestamp
//     * @param randomstr
//     * @param msgBody   加密后的报文
//     * @return
//     * @throws Exception
//     */
//    public static String Signature(String bdatName, String timestamp, String randomstr, String msgBody)
//            throws Exception {
//        String[] paramArr = new String[]{msgBody, timestamp, randomstr};
//        Arrays.sort(paramArr);
//        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);
//        try {
//            Signature signet = Signature.getInstance("SHA1withDSA");
//            byte[] prikeyByte = Base64.decode("MIHGAgEAMIGoBgcqhkjOOAQBMIGcAkEA/KaCzo4Syrom78z3EQ5SbbB4sF7ey80etKII864WF64B81uRpH5t9jQTxeEu0ImbzRMqzVDZkVG9xD7nN1kuFwIVAJYu3cw2nLqOuyYO5rahJtk0bjjFAkBnhHGyepz0TukaScUUfbGpqvJE8FpDTWSGkx0tFCcbnjUDC3H9c9oXkGmzLik1Yw4cIGI1TQ2iCmxBblC+eUykBBYCFA2eZ9aLJXdbIK03aTmejqBWadDp");//FileUtils.readFileToByteArray(new File("src/main/resources/1234567890ABCDEF.pri"));// 文件和路径需要根据真实appid修改
//            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(prikeyByte);
//            KeyFactory keyf = KeyFactory.getInstance("DSA");
//            PrivateKey myprikey = keyf.generatePrivate(priPKCS8);
//            signet.initSign(myprikey);
//            signet.update(content.getBytes("utf-8"));
//            byte[] signed = signet.sign();
//            String signatureStr = new String(Base64Coder.encode(signed));
//            return signatureStr;
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//
//    /**
//     * POST请求，字符串形式数据
//     *
//     * @param url     请求地址
//     * @param param   请求数据
//     * @param charset 编码方式
//     * @throws Exception
//     */
//    public static String sendPostUrl(String url, String param, String charset) throws Exception {
//
//        String timestamp = TestJMServlet.sdf.format(new Date());
//        String randomstr = RandomStringUtils.randomAlphanumeric(8);
//
//        String signaturestr = TestJMServlet.Signature(TestJMServlet.appid, timestamp, randomstr, param);
//        String result = "";
//        try {
//            URL realUrl = new URL(url);
//            URLConnection conn = realUrl.openConnection();
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("Content-Type", "text/html");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("timestamp", timestamp);
//            conn.setRequestProperty("randomstr", randomstr);
//            conn.setRequestProperty("appid", TestJMServlet.appid);
//            conn.setRequestProperty("signature", signaturestr);
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            IOUtils.write(param, conn.getOutputStream(), charset);
//            result = IOUtils.toString(conn.getInputStream(), charset);
//        } catch (Exception e) {
//            throw e;
//        }
//        return result;
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        String data = FileUtils.readFileToString(new File(TestJMServlet.dqphcx), "gbk");//文档中定义的开票报文
//        String paramData = new String(Base64Coder.encode(AESutil.jdkAESEnByKey(TestJMServlet.aeskey, data, "utf-8")));
//        String str = TestJMServlet.sendPostUrl(TestJMServlet.url, paramData, "utf-8");
//
//        try {
//            str = AESutil.jdkAESDeByKey(TestJMServlet.aeskey, Base64Coder.decode(str), "utf-8");
//
//            System.out.println(str);
//        } catch (Exception e) {
//            str = new String(Base64Coder.decode(str), "utf-8");
//        }
//    }
//
//}

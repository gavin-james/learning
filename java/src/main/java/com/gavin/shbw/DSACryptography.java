//package com.gavin.shbw;
//
//import java.security.KeyPairGenerator;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.Signature;
//
//public class DSACryptography {
//
//    public static void main(String[] args) throws Exception {
//        // 初始化DSA密钥生成器
//        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
//        keyPairGenerator.initialize(1024);
//
//        // 生成DSA密钥对
////        KeyPair keyPair = keyPairGenerator.generateKeyPair();
//        PublicKey publicKey = keyPair.getPublic();
//        PrivateKey privateKey = keyPair.getPrivate();
//
//
//        // 原始数据
//        String data = "Hello, DSA!";
//
//        // 使用公钥加密
//        byte[] signedData = DSACryptography.signData(data.getBytes(), privateKey);
//
//        // 使用私钥解密
//        boolean isVerified = DSACryptography.verifySignature(data.getBytes(), signedData, publicKey);
//
//        // 输出结果
//        System.out.println("Signature verified: " + isVerified);
//    }
//
//    private static byte[] signData(byte[] data, PrivateKey privateKey) throws Exception {
//        Signature dsa = Signature.getInstance("DSA");
//        dsa.initSign(privateKey);
//        dsa.update(data);
//        return dsa.sign();
//    }
//
//    private static boolean verifySignature(byte[] data, byte[] signedData, PublicKey publicKey) throws Exception {
//        Signature dsa = Signature.getInstance("DSA");
//        dsa.initVerify(publicKey);
//        dsa.update(data);
//        return dsa.verify(signedData);
//    }
//}
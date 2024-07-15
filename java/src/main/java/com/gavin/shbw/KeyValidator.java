//package com.gavin.shbw;
//
//import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
//import org.bouncycastle.crypto.util.PrivateKeyFactory;
//import org.bouncycastle.crypto.util.PublicKeyFactory;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.security.KeyFactory;
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
//
//public class KeyValidator {
//
//    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
//        // 验证 .pri 文件
//        KeyValidator.validatePrivateKey("privateKey.pri");
//
//        // 验证 .pub 文件
//        KeyValidator.validatePublicKey("publicKey.pub");
//    }
//
//    private static void validatePrivateKey(String privateKeyPath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
//        // 加载私钥文件
//        byte[] privateKeyBytes = KeyValidator.readBytesFromFile(privateKeyPath);
//
//        // 创建 KeyFactory 实例
//        KeyFactory keyFactory = PrivateKeyFactory.getInstance("RSA", new BouncyCastleProvider());
//
//        // 解析私钥
//        AsymmetricKeyParameter privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
//
//        // 验证私钥是否有效
//        if (!privateKey.isPrivate()) {
//            throw new InvalidKeySpecException("Invalid private key");
//        }
//
//        System.out.println("Private key is valid");
//    }
//
//    private static void validatePublicKey(String publicKeyPath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
//        // 加载公钥文件
//        byte[] publicKeyBytes = KeyValidator.readBytesFromFile(publicKeyPath);
//
//        // 创建 KeyFactory 实例
//        KeyFactory keyFactory = PublicKeyFactory.getInstance("RSA", new BouncyCastleProvider());
//
//        // 解析公钥
//        AsymmetricKeyParameter publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
//
//        // 验证公钥是否有效
//        if (!publicKey.isPublic()) {
//            throw new InvalidKeySpecException("Invalid public key");
//        }
//
//        System.out.println("Public key is valid");
//    }
//
//    private static byte[] readBytesFromFile(String filePath) throws IOException {
//        try (FileInputStream fis = new FileInputStream(filePath)) {
//            byte[] bytes = new byte[fis.available()];
//            fis.read(bytes);
//            return bytes;
//        }
//    }
//}
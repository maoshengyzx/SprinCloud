package com.execise.demo.common.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

//AES加密解密工具类
public class AESUtil {

    private static final String AES_ALGORITHM = "AES";
    private static final String CIPHER_MODE = "AES/CBC/PKCS5Padding";
    private static final String INIT_VECTOR = "YourInitVector"; // 初始化向量
    private static final String SECRET_KEY = "YourSecretKey"; // 密钥

    /**
     * 加密
     * @param plainText
     * @return
     */
    public static String encrypt(String plainText) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);

            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);

            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密
     * @param encryptedText
     * @return
     */
    public static String decrypt(String encryptedText) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);

            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);

            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String originalText = "Hello, World! This is a test message.";

        // 加密
        String encryptedText = encrypt(originalText);
        System.out.println("Encrypted Text: " + encryptedText);

        // 解密
        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}

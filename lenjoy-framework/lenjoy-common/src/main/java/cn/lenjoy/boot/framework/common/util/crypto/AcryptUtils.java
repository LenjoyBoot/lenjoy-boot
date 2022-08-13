package cn.lenjoy.boot.framework.common.util.crypto;

import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import lombok.*;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @description: 非对称加密算法
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 09 星期二
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class AcryptUtils {

    private AcryptUtils() {}

    /**
     * 非对称加密算法
     * @param text 密文 base64
     * @param key 解密密钥(公钥或私钥)
     * @param algorithm 算法
     * @return 明文
     */
    @SneakyThrows
    public static String decryptBase64(String text, Key key, String algorithm) {
        return decrypt(decode(text), key, algorithm);
    }

    /**
     * 非对称加密算法
     * @param text 密文 bytes
     * @param key 解密密钥(公钥或私钥)
     * @param algorithm 算法
     * @return 明文
     */
    @SneakyThrows
    public static String decrypt(byte[] text, Key key, String algorithm) {
        assertAlgorithm(algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(text);
        return new String(bytes);
    }

    /**
     * 非对称加密算法 私钥加密
     * @param text 明文
     * @param key 加密密钥(公钥或私钥)
     * @param algorithm 算法
     * @return 密文
     */
    public static String encryptBase64(String text, Key key, String algorithm) {
        return encode(encrypt(text, key, algorithm));
    }

    /**
     * 非对称加密算法
     * @param text 明文
     * @param key 加密密钥(公钥或私钥)
     * @param algorithm 算法
     * @return 密文
     */
    @SneakyThrows
    public static byte[] encrypt(String text, Key key, String algorithm) {
        assertAlgorithm(algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 生成密钥对
     * @param algorithm 算法
     * @return 密钥对（base64转码）
     */
    public static Base64KeyPair getKeyPair(String algorithm) {
        assertAlgorithm(algorithm);
        KeyPair keyPair = generateKeyPair(algorithm);
        return new Base64KeyPair(encode(keyPair.getPrivate().getEncoded()), encode(keyPair.getPublic().getEncoded()));
    }

    /**
     * 生成密钥对
     * @param algorithm 算法
     * @return 密钥对
     */
    @SneakyThrows
    public static KeyPair generateKeyPair(String algorithm) {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        return keyPairGenerator.generateKeyPair();
    }

    /**
     * 获取私钥
     * @param key base64编码
     * @param algorithm 算法
     * @return 私钥
     */
    @SneakyThrows
    public static PrivateKey getPrivateKey(String key, String algorithm) {
        PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(decode(key));
        return KeyFactory.getInstance(algorithm).generatePrivate(encodedKeySpec);
    }

    /**
     * 获取公钥
     * @param key base64编码
     * @param algorithm 算法
     * @return 公钥
     */
    @SneakyThrows
    public static PublicKey getPublicKey(String key, String algorithm) {
        X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(decode(key));
        return KeyFactory.getInstance(algorithm).generatePublic(encodedKeySpec);
    }

    /**
     * base 解码
     * @param text 被解码文 String
     * @return 解码文
     */
    public static byte[] decode(String text) {
        return Base64.getDecoder().decode(text);
    }

    /**
     * base 编码
     * @param bytes 被编码文 bytes
     * @return 编码文
     */
    public static String encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 仅支持 RSA，暂不支持 ECC
     * @param algorithm 算法
     */
    private static void assertAlgorithm(String algorithm) {
        AssertUtils.notFalse(StringUtils.isNotEquals(AcryptEnum.RSA.getAlgorithm(), algorithm), "不支持的算法，请使用 RSA");
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class Base64KeyPair {
        private String privateKey;
        private String publicKey;
    }

    @Getter
    @AllArgsConstructor
    public enum AcryptEnum {
        /**
         * 加密算法枚举
         */
        RSA("RSA"),
        ECC("ECC"),
        ;

        /**
         * 加密算法
         */
        private final String algorithm;
    }

}

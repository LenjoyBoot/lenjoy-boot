package cn.lenjoy.boot.framework.common.util.crypto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @description: 乐享 Digest摘要算法工具类，使用JDK自带
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 09 星期二
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class DigestUtils {

    /**
     * 获取加密密文（SHA512）
     * @param text 明文
     * @return 密文
     */
    public static String sha512(String text) {
        return digest(text, DigestEnum.SHA512.getAlgorithm());
    }

    /**
     * 获取加密密文（SHA256）
     * @param text 明文
     * @return 密文
     */
    public static String sha256(String text) {
        return digest(text, DigestEnum.SHA256.getAlgorithm());
    }

    /**
     * 获取加密密文（SHA1）
     * @param text 明文
     * @return 密文
     */
    public static String sha1(String text) {
        return digest(text, DigestEnum.SHA1.getAlgorithm());
    }

    /**
     * 获取加密密文（MD5）
     * @param text 明文
     * @return 密文
     */
    public static String md5(String text) {
        return digest(text, DigestEnum.MD5.getAlgorithm());
    }

    /**
     * Digest摘要算法，获取加密密文
     * @param text 明文
     * @param algorithm 算法
     * @return 密文
     */
    @SneakyThrows
    public static String digest(String text, String algorithm) {
        // 创建加密对象，指定算法类型
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        // 加密
        byte[] digest = messageDigest.digest(text.getBytes(StandardCharsets.UTF_8));
        // 密文补'0'
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            String toHexString = Integer.toHexString(b & 0xff);
            if (toHexString.length() == 1) {
                toHexString = '0' + toHexString;
            }
            sb.append(toHexString);
        }
        return sb.toString();
    }

    @Getter
    @AllArgsConstructor
    public enum DigestEnum {
        /**
         * 加密算法枚举
         */
        MD5("MD5"),
        SHA1("SHA-1"),
        SHA256("SHA-256"),
        SHA512("SHA-512"),
        ;

        /**
         * 加密算法
         */
        private final String algorithm;
    }

}

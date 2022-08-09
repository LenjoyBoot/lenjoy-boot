package cn.lenjoy.boot.framework.common.util.crypt;

import lombok.SneakyThrows;

/**
 * @description: 加密工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 07 星期日
 * @version: 1.0.0
 */
public class MCryptUtils {

    private MCryptUtils() {}

    private static final String META_CRYPT_KEY = "aes2022=";

    /**
     * 文本加密
     *
     * @param text 加密字符串
     * @return 加密后的文本
     */
    @SneakyThrows
    public static String encrypt(String text) {
        return ScryptUtils.desEncrypt(text, META_CRYPT_KEY);
    }

    /**
     * 文本解密
     * @param text 解密字符串
     * @return 解密后的文本
     */
    @SneakyThrows
    public static String decrypt(String text) {
        return ScryptUtils.desDecrypt(text, META_CRYPT_KEY);
    }
}

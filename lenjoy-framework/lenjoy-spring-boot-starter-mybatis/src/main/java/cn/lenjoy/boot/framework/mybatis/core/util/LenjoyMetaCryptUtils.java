package cn.lenjoy.boot.framework.mybatis.core.util;

import cn.lenjoy.boot.framework.common.util.crypto.ScryptUtils;
import lombok.SneakyThrows;

/**
 * @description: 乐享 MyBatis 工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 17 星期五
 * @version: 1.0.0
 */
public class LenjoyMetaCryptUtils {

    private LenjoyMetaCryptUtils() {}

    private static final String METE_CRYPT_KEY = "meta2022";

    /**
     * 文本加密
     *
     * @param text 加密字符串
     * @return 加密后的文本
     */
    @SneakyThrows
    public static String encrypt(String text) {
        return ScryptUtils.desEncrypt(text, METE_CRYPT_KEY);
    }

    /**
     * 文本解密
     * @param text 解密字符串
     * @return 解密后的文本
     */
    @SneakyThrows
    public static String decrypt(String text) {
        return ScryptUtils.desDecrypt(text, METE_CRYPT_KEY);
    }
}

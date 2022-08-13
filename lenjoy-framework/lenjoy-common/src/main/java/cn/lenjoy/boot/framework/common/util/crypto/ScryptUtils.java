package cn.lenjoy.boot.framework.common.util.crypto;

import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @description: 对称加密算法
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 09 星期二
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class ScryptUtils {

    private ScryptUtils() {}

    /**
     * 对称加密算法（AES）
     * AES/ECB/PKCS5Padding
     *
     * @param text 密文
     * @param key 加密密钥
     * @return 明文
     */
    public static String aesDecrypt(String text, String key) {
        // 校验key长度
        AssertUtils.isTrue(key.getBytes(StandardCharsets.UTF_8).length == 16, "key 长度必须为16位");
        return decrypt(text, key, ScryptEnum.AES.getAlgorithm(), ModelEnum.ECB.getModel(), PaddingEnum.PKCS5PADDING.getPadding());
    }

    /**
     * 对称加密算法（AES）
     * AES/ECB/PKCS5Padding
     *
     * @param text 明文
     * @param key 加密密钥
     * @return 密文
     */
    public static String aesEncrypt(String text, String key) {
        // 校验key长度
        AssertUtils.isTrue(key.getBytes(StandardCharsets.UTF_8).length == 16, "key 长度必须为16位");
        return encrypt(text, key, ScryptEnum.AES.getAlgorithm(), ModelEnum.ECB.getModel(), PaddingEnum.PKCS5PADDING.getPadding());
    }

    /**
     * 对称加密算法（DES）
     * DES/ECB/PKCS5Padding
     *
     * @param text 密文
     * @param key 加密密钥
     * @return 明文
     */
    public static String desDecrypt(String text, String key) {
        // 校验key长度
        AssertUtils.isTrue(key.getBytes(StandardCharsets.UTF_8).length == 8, "key 长度必须为8位");
        return decrypt(text, key, ScryptEnum.DES.getAlgorithm(), ModelEnum.ECB.getModel(), PaddingEnum.PKCS5PADDING.getPadding());
    }

    /**
     * 对称加密算法（DES）
     * DES/ECB/PKCS5Padding
     *
     * @param text 明文
     * @param key 加密密钥
     * @return 密文
     */
    public static String desEncrypt(String text, String key) {
        // 校验key长度
        AssertUtils.isTrue(key.getBytes(StandardCharsets.UTF_8).length == 8, "key 长度必须为8位");
        return encrypt(text, key, ScryptEnum.DES.getAlgorithm(), ModelEnum.ECB.getModel(), PaddingEnum.PKCS5PADDING.getPadding());
    }

    /**
     * 对称加密算法（DES）
     * ECB 密码本模式
     * @param text 明文
     * @param key 加密密钥
     * @param algorithm 算法
     * @param model 模式
     * @param padding 填充方式
     * @return 密文
     */
    @SneakyThrows
    public static String decrypt(String text, String key, String algorithm, String model, String padding) {
        String algorithmStr = String.join("/", algorithm, model, padding);
        Cipher cipher = Cipher.getInstance(algorithmStr);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), algorithm);
        // 仅CBC 模式
        if (StringUtils.isEquals(ModelEnum.CBC.getModel(), model)) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(secretKeySpec.getEncoded());
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        }
        byte[] decode = Base64.getDecoder().decode(text.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = cipher.doFinal(decode);
        return new String(bytes);
    }

    /**
     * 对称加密算法
     * @param text 明文
     * @param key 加密密钥
     * @param algorithm 算法
     * @param model 模式
     * @param padding 填充方式
     * @return 密文
     */
    @SneakyThrows
    public static String encrypt(String text, String key, String algorithm, String model, String padding) {
        String algorithmStr = String.join("/", algorithm, model, padding);
        Cipher cipher = Cipher.getInstance(algorithmStr);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), algorithm);
        // 仅CBC 模式
        if (StringUtils.isEquals(ModelEnum.CBC.getModel(), model)) {
            // 此处提示需使用随机向量，需要保存随机向量值，但key是保密的，暂不做随机处理
            @SuppressWarnings("all")
            IvParameterSpec ivParameterSpec = new IvParameterSpec(secretKeySpec.getEncoded());
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        }
        byte[] bytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Getter
    @AllArgsConstructor
    public enum ScryptEnum {
        /**
         * 加密算法枚举
         */
        DES("DES"),
        AES("AES"),
        ;

        /**
         * 加密算法
         */
        private final String algorithm;
    }

    @Getter
    @AllArgsConstructor
    public enum ModelEnum {
        /**
         * 加密枚举
         */
        ECB("ECB"),
        CBC("CBC"),
        ;

        /**
         * 加密模式
         */
        private final String model;
    }

    @Getter
    @AllArgsConstructor
    public enum PaddingEnum {
        /**
         * 加密填充枚举
         */
        NOPADDING("NoPadding"),
        PKCS5PADDING("PKCS5Padding"),
        ;

        /**
         * 加密填充方式
         */
        private final String padding;
    }

}

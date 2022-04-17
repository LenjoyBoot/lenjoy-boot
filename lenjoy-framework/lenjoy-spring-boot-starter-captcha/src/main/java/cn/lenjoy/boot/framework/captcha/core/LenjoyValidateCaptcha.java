package cn.lenjoy.boot.framework.captcha.core;

/**
 * @description: 验证码验证接口
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
public interface LenjoyValidateCaptcha {
    /**
     * 验证是否正确
     * @param sourceCode 源验证码
     * @param targetCode 目标验证码
     * @return 是否正确
     */
    boolean validate(String sourceCode, String targetCode);

    /**
     * 验证是否正确
     * @param sourceCode 源验证码
     * @param targetCode 目标验证码
     * @param ignore 忽略大小写
     * @return 是否正确
     */
    boolean validate(String sourceCode, String targetCode, boolean ignore);
}

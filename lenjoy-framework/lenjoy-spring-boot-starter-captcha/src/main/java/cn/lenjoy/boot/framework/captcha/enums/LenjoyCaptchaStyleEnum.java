package cn.lenjoy.boot.framework.captcha.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 验证码表示类型
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum LenjoyCaptchaStyleEnum {
    /**
     *
     */
    IMAGE(0, "默认,静态图片"),
    ANIMATION(1, "GIF,动画"),
    ;

    private final Integer code;
    private final String desc;

    public static boolean noType(Integer code) {
        return !hasType(code);
    }

    public static boolean hasType(Integer code) {
        for (LenjoyCaptchaStyleEnum value : LenjoyCaptchaStyleEnum.values()) {
            if (value.code.equals(code)) {
                return true;
            }
        }
        return false;
    }
}

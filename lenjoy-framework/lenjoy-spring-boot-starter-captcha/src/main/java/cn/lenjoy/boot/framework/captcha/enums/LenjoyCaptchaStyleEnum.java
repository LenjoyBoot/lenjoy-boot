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
     * 验证码表示类型
     */
    // 图片
    IMAGE,
    // 动画
    ANIMATION
}

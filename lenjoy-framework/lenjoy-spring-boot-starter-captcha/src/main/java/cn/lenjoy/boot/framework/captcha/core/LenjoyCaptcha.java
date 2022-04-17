package cn.lenjoy.boot.framework.captcha.core;

import cn.lenjoy.boot.framework.captcha.enums.LenjoyCaptchaStyleEnum;
import cn.lenjoy.boot.framework.captcha.enums.LenjoyCaptchaTypeEnum;
import lombok.Data;

/**
 * @description: 乐享验证码对象
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@Data
public class LenjoyCaptcha {
    /**
     * 验证码键
     */
    private String key;
    /**
     * 验证码值
     */
    private String value;
    /**
     * 验证码类型
     */
    private LenjoyCaptchaTypeEnum type;
    /**
     * 验证码表现类型
     */
    private LenjoyCaptchaStyleEnum style;
    /**
     * 验证码过期数
     */
    private Long timeout;
}

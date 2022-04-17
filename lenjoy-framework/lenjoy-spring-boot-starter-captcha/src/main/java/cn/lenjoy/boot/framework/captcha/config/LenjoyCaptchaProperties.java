package cn.lenjoy.boot.framework.captcha.config;

import cn.lenjoy.boot.framework.captcha.enums.LenjoyCaptchaStyleEnum;
import cn.lenjoy.boot.framework.captcha.enums.LenjoyCaptchaTypeEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: 验证码配置
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@ConfigurationProperties(prefix = "lenjoy.captcha")
@Data
public class LenjoyCaptchaProperties {
    /**
     * 验证码类型
     */
    private LenjoyCaptchaTypeEnum type = LenjoyCaptchaTypeEnum.DEFAULT;
    /**
     * 验证码表现形式
     */
    private LenjoyCaptchaStyleEnum style = LenjoyCaptchaStyleEnum.IMAGE;
    /**
     * 验证码长度
     */
    private int length = 4;
    /**
     * 验证码过期时间
     */
    private long timeout = 60L;
}

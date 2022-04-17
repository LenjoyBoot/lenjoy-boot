package cn.lenjoy.boot.framework.captcha.config;

import cn.lenjoy.boot.framework.captcha.core.AbstractCaptcha;
import cn.lenjoy.boot.framework.captcha.core.LenjoyGraphicCaptcha;
import cn.lenjoy.boot.framework.captcha.enums.LenjoyCaptchaStyleEnum;
import cn.lenjoy.boot.framework.captcha.enums.LenjoyCaptchaTypeEnum;
import cn.lenjoy.boot.framework.captcha.exception.LenjoyCaptchaArgumentException;
import cn.lenjoy.boot.framework.captcha.exception.LenjoyCaptchaNotFoundException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: CaptchaAutoConfiguration 配置类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@Configuration
@ConditionalOnClass(AbstractCaptcha.class)
@EnableConfigurationProperties(LenjoyCaptchaProperties.class)
public class LenjoyCaptchaAutoConfiguration {

    private final LenjoyCaptchaProperties lenjoyCaptchaProperties;

    public LenjoyCaptchaAutoConfiguration(LenjoyCaptchaProperties lenjoyCaptchaProperties) {
        this.lenjoyCaptchaProperties = lenjoyCaptchaProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public AbstractCaptcha defaultCaptcha() {
        if (LenjoyCaptchaTypeEnum.noType(lenjoyCaptchaProperties.getType())) {
            throw new LenjoyCaptchaNotFoundException();
        }
        if (LenjoyCaptchaStyleEnum.noType(lenjoyCaptchaProperties.getStyle())) {
            throw new LenjoyCaptchaNotFoundException();
        }
        if (lenjoyCaptchaProperties.getLength() < 4 || lenjoyCaptchaProperties.getLength() > 8) {
            throw new LenjoyCaptchaArgumentException();
        }
        return new LenjoyGraphicCaptcha(lenjoyCaptchaProperties.getType(), lenjoyCaptchaProperties.getStyle(), lenjoyCaptchaProperties.getLength());
    }
}

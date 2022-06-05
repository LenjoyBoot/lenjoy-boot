package cn.lenjoy.boot.framework.security.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 乐享 Spring Security 自动配置类
 *
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(LenjoySecurityProperties.class)
public class LenjoySecurityAutoConfiguration {

    private final LenjoySecurityProperties lenjoySecurityProperties;

    public LenjoySecurityAutoConfiguration(LenjoySecurityProperties lenjoySecurityProperties) {
        this.lenjoySecurityProperties = lenjoySecurityProperties;
    }

}

package cn.lenjoy.boot.framework.banner.config;

import cn.lenjoy.boot.framework.banner.core.LenjoyBannerApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: lenjoy banner 自动配置类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 07 星期日
 * @version: 1.0.0
 */
@Configuration
public class LenjoyBannerAutoConfiguration {
    @Bean
    public LenjoyBannerApplicationRunner lenjoyBannerApplicationRunner() {
        return new LenjoyBannerApplicationRunner();
    }
}

package cn.lenjoy.boot.framework.social.gitee.config;

import cn.lenjoy.boot.framework.social.gitee.core.LenjoySocialGitee;
import cn.lenjoy.boot.framework.social.gitee.core.LenjoySocialGiteeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@Slf4j
@Configuration
@ConditionalOnClass(LenjoySocialGiteeProperties.class)
@EnableConfigurationProperties(LenjoySocialGiteeProperties.class)
@ConditionalOnProperty(prefix = "lenjoy.social.gitee", value = "enable", havingValue = "true", matchIfMissing = true)
public class LenjoySocialGiteeAutoConfiguration {

    private final LenjoySocialGiteeProperties lenjoySocialGiteeProperties;

    public LenjoySocialGiteeAutoConfiguration(LenjoySocialGiteeProperties lenjoySocialGiteeProperties) {
        this.lenjoySocialGiteeProperties = lenjoySocialGiteeProperties;
    }

    @Bean
    public LenjoySocialGitee lenjoySocialGitee() {
        return new LenjoySocialGiteeImpl(lenjoySocialGiteeProperties);
    }

}

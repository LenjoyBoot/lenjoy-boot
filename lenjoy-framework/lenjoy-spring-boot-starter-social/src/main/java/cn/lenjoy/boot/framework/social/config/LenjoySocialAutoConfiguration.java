package cn.lenjoy.boot.framework.social.config;

import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.common.util.spring.SpringUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import cn.lenjoy.boot.framework.social.core.LenjoySocialService;
import cn.lenjoy.boot.framework.social.core.LenjoySocialStrategy;
import cn.lenjoy.boot.framework.social.enums.LenjoySocialPlatformEnum;
import cn.lenjoy.boot.framework.social.core.gitee.LenjoySocialGiteeService;
import cn.lenjoy.boot.framework.social.core.gitee.impl.LenjoySocialGiteeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cn.lenjoy.boot.framework.common.constant.SpecialConstant.STR_DO;

/**
 * @description: 乐享社区认证自动配置
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@Slf4j
@Configuration
@ConditionalOnClass({LenjoySocialProperties.class, LenjoySocialGiteeProperties.class})
@EnableConfigurationProperties({LenjoySocialProperties.class, LenjoySocialGiteeProperties.class})
@ConditionalOnProperty(prefix = "lenjoy.social", value = "enable", havingValue = "true", matchIfMissing = true)
public class LenjoySocialAutoConfiguration {

    private final LenjoySocialProperties lenjoySocialProperties;

    public LenjoySocialAutoConfiguration(LenjoySocialProperties lenjoySocialProperties) {
        this.lenjoySocialProperties = lenjoySocialProperties;
    }

    @Bean
    public LenjoySocialStrategy lenjoySocialStrategy() {
        List<LenjoySocialService> services = new ArrayList<>();
        // 通过 配置类型加载 社区服务
        String typesString = lenjoySocialProperties.getTypes();
        AssertUtils.isTrue(StringUtils.isNotBlank(typesString), "社交类型不可为空");
        List<String> types = Arrays.asList(typesString.split(STR_DO));
        AssertUtils.isTrue(types.stream().allMatch(LenjoySocialPlatformEnum::hasType), "存在不支持的社交类型");
        types.forEach(type -> {
            if (StringUtils.isEquals(LenjoySocialPlatformEnum.GITEE.getCode(), type)) {
                services.add(lenjoySocialGiteeService());
            }
        });
        AssertUtils.notNull(services, "社交登录配置异常，未加载任意社交类型");
        return new LenjoySocialStrategy(services);
    }

    /**
     * 动态注入 gitee 社交登录
     */
    public LenjoySocialGiteeService lenjoySocialGiteeService() {
        // 运行时动态注入 bean
        SpringUtils.registerBeanBy("lenjoySocialGiteeService", LenjoySocialGiteeServiceImpl.class);
        return SpringUtils.getBeanBy("lenjoySocialGiteeService");
    }
}

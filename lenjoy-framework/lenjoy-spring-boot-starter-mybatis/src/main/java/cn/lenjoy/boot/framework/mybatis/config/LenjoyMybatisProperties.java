package cn.lenjoy.boot.framework.mybatis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @description:
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 16 星期四
 * @version: 1.0.0
 */
@Data
@Validated
@ConfigurationProperties(prefix = "lenjoy.mybatis")
public class LenjoyMybatisProperties {
}

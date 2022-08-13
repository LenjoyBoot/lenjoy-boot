package cn.lenjoy.boot.framework.web.restemplate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @description: 乐享 RestTemplate 配置
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */

@Data
@Validated
@ConfigurationProperties("lenjoy.restemplate")
public class LenjoyRestTemplateProperties {
    /**
     * 读取超时 3秒
     */
    private Integer readTimeout = -1;

    /**
     * 连接超时 30秒
     */
    private Integer connectTimeout = -1;
}

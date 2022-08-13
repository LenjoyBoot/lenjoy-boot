package cn.lenjoy.boot.framework.social.gitee.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @description: 乐享社区认证 Gitee
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@Data
@Validated
@ConfigurationProperties("lenjoy.social.gitee")
public class LenjoySocialGiteeProperties {

    /**
     * Gitee认证后重定向地址
     */
    @NotEmpty(message = "Gitee认证后重定向地址,不可为空")
    private String redirectUrl;

    /**
     * Gitee第三方应用 client_id
     */
    @NotEmpty(message = "Gitee第三方应用 client_id,不可为空")
    private String clientId;

    /**
     * Gitee第三方应用 client_secret
     */
    @NotEmpty(message = "Gitee第三方应用 client_secret,不可为空")
    private String clientSecret;
}

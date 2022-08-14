package cn.lenjoy.boot.framework.social.config;

import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import cn.lenjoy.boot.framework.social.enums.LenjoySocialPlatformEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.AssertTrue;

/**
 * @description: 乐享社区认证 Gitee
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@Data
@Validated
@ConfigurationProperties("lenjoy.social")
public class LenjoySocialProperties {

    /**
     * 社交认证是否开启
     */
    private boolean enable = true;

    /**
     * 社交认证类型列表(','隔开)
     */
    private String types;

    @AssertTrue(message = "社交认证类型列表不可为空")
    @SuppressWarnings("unused")
    public boolean enableTypes() {
        if (!enable) {
            return true;
        }
        if (StringUtils.isNotBlank(types)) {
            for (String type : types.split(",")) {
                AssertUtils.isTrue(LenjoySocialPlatformEnum.hasType(type), "不支持的社交认证类型" + type);
            }
            return true;
        }
        return false;
    }
}

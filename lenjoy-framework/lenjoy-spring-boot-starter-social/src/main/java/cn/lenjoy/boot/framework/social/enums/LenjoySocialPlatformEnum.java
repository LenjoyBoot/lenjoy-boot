package cn.lenjoy.boot.framework.social.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 社交平台登录枚举
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 14 星期日
 * @version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum LenjoySocialPlatformEnum {
    /**
     * 社交登录枚举
     * Gitee 码云
     * GitHub GitHub
     * GitLab GitLab
     */
    GITEE("Gitee",  "码云"),
    GITHUB("GitHub", "GitHub"),
    GITLAB("GitLab", "GitLab"),
    ;
    /**
     * 值
     */
    private final String code;
    /**
     * 描述
     */
    private final String desc;

    public static boolean hasType(String type) {
        for (LenjoySocialPlatformEnum enums : LenjoySocialPlatformEnum.values()) {
            if (enums.code.equals(type)) {
                return true;
            }
        }
        return false;
    }
}

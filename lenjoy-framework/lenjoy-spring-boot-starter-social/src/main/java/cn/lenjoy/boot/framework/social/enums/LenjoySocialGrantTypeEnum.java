package cn.lenjoy.boot.framework.social.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 社交登录认证模式枚举
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 14 星期日
 * @version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum LenjoySocialGrantTypeEnum {
    /**
     * 社交登录认证模式枚举
     * 授权码
     * 密码
     */
    CODE("code", "授权码模式"),
    PASSWORD("password",  "密码模式"),
    ;
    /**
     * 值
     */
    private final String code;
    /**
     * 描述
     */
    private final String desc;
}

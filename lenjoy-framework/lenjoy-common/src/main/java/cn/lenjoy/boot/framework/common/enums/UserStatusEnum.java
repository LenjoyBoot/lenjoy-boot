package cn.lenjoy.boot.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 用户状态枚举
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum {
    ENABLE(0, "可用"),
    DISABLE(1, "禁用"),
    ACCOUNT_EXPIRED(2, "账号已过期"),
    ACCOUNT_LOCKED(3, "账号已锁定"),
    CREDENTIALS_EXPIRED(4, "密码已过期"),
    ;
    /**
     * 类型值
     */
    private final Integer code;

    /**
     * 类型描述
     */
    private final String desc;
}

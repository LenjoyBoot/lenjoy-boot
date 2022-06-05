package cn.lenjoy.boot.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 用户类型枚举
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    TOURIST(0, "游客"),
    MEMBER(1, "会员"),
    BUSINESS(2, "商家"),
    ADMIN(3, "管理员"),
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

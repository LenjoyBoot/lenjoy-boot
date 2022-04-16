package cn.lenjoy.boot.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 状态枚举
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    AVAILABLE(0, "可用"),
    UNAVAILABLE(1, "不可用"),
    ;
    /**
     * 状态值
     */
    private final Integer code;
    /**
     * 状态描述
     */
    private final String desc;
}

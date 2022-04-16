package cn.lenjoy.boot.framework.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 代码消息
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@Getter
@AllArgsConstructor
public class CodeMsg {


    /**
     * 异常代码
     * 例如 '00000000' 8位代码
     * 第一位：
     *      0   预留级别
     *      1-9 系统级别 需约定
     *      A-Z 模块级别 需约定
     */
    private final String code;

    /**
     * 异常消息
     */
    private final String msg;
}

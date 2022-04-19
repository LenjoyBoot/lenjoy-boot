package cn.lenjoy.boot.framework.common.exception;

import cn.lenjoy.boot.framework.common.base.CodeMsg;

/**
 * @description: 基础异常类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class BaseException extends RuntimeException {

    private static final String CODE = "代码: ";
    private static final String MSG = ", 信息: ";
    private static final String SUFFIX = ".";

    // 自定义构造异常

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String code, String msg) {
        super(CODE + code + MSG + msg + SUFFIX);
    }

    public BaseException(CodeMsg codeMsg) {
        super(CODE + codeMsg.getCode() + MSG + codeMsg.getMsg() + SUFFIX);
    }

    /**
     * 无参构造
     */
    public BaseException() { }
}

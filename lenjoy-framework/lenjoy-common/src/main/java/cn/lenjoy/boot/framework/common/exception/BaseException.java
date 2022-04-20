package cn.lenjoy.boot.framework.common.exception;

import cn.lenjoy.boot.framework.common.base.CodeMsg;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description: 基础异常类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {

    private static final String CODE_PREFIX = "代码: ";
    private static final String MSG_PREFIX = ", 信息: ";
    private static final String MSG_SUFFIX = ".";

    private final String code;
    private final String msg;

    public BaseException(String msg, String code) {
        super(CODE_PREFIX + code + MSG_PREFIX + msg + MSG_SUFFIX);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(CodeMsg codeMsg) {
        super(CODE_PREFIX + codeMsg.getCode() + MSG_PREFIX + codeMsg.getMsg() + MSG_SUFFIX);
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

}

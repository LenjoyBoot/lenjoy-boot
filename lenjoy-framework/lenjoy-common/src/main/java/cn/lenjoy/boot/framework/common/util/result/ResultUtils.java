package cn.lenjoy.boot.framework.common.util.result;

import cn.lenjoy.boot.framework.common.base.CodeMsg;
import cn.lenjoy.boot.framework.common.base.response.BaseRes;
import cn.lenjoy.boot.framework.common.exception.ErrorCodeMsg;

import java.io.Serializable;

/**
 * @description: 统一返回实体工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public final class ResultUtils<T> implements Serializable {

    public static <T> BaseRes<T> ok(T content) {
        BaseRes<T> res = new BaseRes<>();
        res.setCode(ErrorCodeMsg.SUCCESS.getCode());
        res.setMsg(ErrorCodeMsg.SUCCESS.getMsg());
        res.setContent(content);
        return res;
    }

    public static <T> BaseRes<T> ok(T content, String msg) {
        BaseRes<T> res = new BaseRes<>();
        res.setCode(ErrorCodeMsg.SUCCESS.getCode());
        res.setMsg(msg);
        res.setContent(content);
        return res;
    }

    public static <T> BaseRes<T> fail(CodeMsg codeMsg) {
        return fail(codeMsg.getCode(), codeMsg.getMsg());
    }

    public static <T> BaseRes<T> fail(String code, String msg) {
        BaseRes<T> res = new BaseRes<>();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }

    public static <T> BaseRes<T> fail() {
        BaseRes<T> res = new BaseRes<>();
        res.setCode(ErrorCodeMsg.FAILED.getCode());
        res.setMsg(ErrorCodeMsg.FAILED.getMsg());
        return res;
    }

    /**
     * 私有构造方法
     */
    private ResultUtils() {}

}

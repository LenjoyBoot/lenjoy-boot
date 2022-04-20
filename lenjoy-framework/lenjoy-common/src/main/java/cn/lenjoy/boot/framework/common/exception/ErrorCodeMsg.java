package cn.lenjoy.boot.framework.common.exception;


import cn.lenjoy.boot.framework.common.base.CodeMsg;

/**
 * @description: 通用代码消息
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public final class ErrorCodeMsg {
    public static final CodeMsg SUCCESS = new CodeMsg("200", "操作成功");
    public static final CodeMsg BAD_REQUEST = new CodeMsg("400", "请求异常");
    public static final CodeMsg UNAUTHORIZED = new CodeMsg("401", "请求未经授权");
    public static final CodeMsg FORBIDDEN = new CodeMsg("403", "请求权限不足");
    public static final CodeMsg NOT_FOUND = new CodeMsg("404", "请求未找到");
    public static final CodeMsg METHOD_NOT_ALLOWED = new CodeMsg("405", "请求方法不正确");
    public static final CodeMsg LOCKED = new CodeMsg("423", "请求重复,请稍后重试");
    public static final CodeMsg TOO_MANY_REQUESTS = new CodeMsg("429", "请求过于频繁，请稍后重试");
    public static final CodeMsg FAILED = new CodeMsg("500", "未知异常");

    /**
     * 私有构造方法
     */
    private ErrorCodeMsg() { }
}

package cn.lenjoy.boot.framework.common.util;

/**
 * @description: 断言工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 19 星期二
 * @version: 1.0.0
 */
public class AssertUtils {

    /**
     * 表达式为 false 抛出异常
     * @param expression 表达式
     * @param message 抛出异常信息
     * @throws IllegalStateException 异常信息
     */
    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * 表达式为 false 抛出异常
     * @param expression 表达式
     * @param message 抛出异常信息
     * @throws IllegalStateException 异常信息
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * 表达式为 不为 false 抛出异常
     * @param expression 表达式
     * @param message 抛出异常信息
     * @throws IllegalStateException 异常信息
     */
    public static void notFalse(boolean expression, String message) {
        if (expression) {
            throw new IllegalStateException(message);
        }
    }

    private AssertUtils(){}

}

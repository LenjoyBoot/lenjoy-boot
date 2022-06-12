package cn.lenjoy.boot.framework.common.util;

/**
 * @description: 断言工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 19 星期二
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
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

    /**
     * 对象不为 null 抛出异常
     * @param object 对象
     * @param message 抛出异常信息
     * @throws IllegalStateException 异常信息
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 对象为 null 抛出异常
     * @param object 对象
     * @param message 抛出异常信息
     * @throws IllegalStateException 异常信息
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 对象不为对应的类型 抛出异常
     *
     * @param type 被检查对象匹配的类型
     * @param obj 被检查对象
     * @param <T> 泛型
     * @throws IllegalStateException 异常信息
     */
    public static <T> void isInstanceOf(Class<?> type, T obj) {
        isInstanceOf(type, obj, "被检查对象不匹配对象类型");
    }

    /**
     * 对象不为对应的类型 抛出异常
     *
     * @param type 被检查对象匹配的类型
     * @param obj 被检查对象
     * @param message 抛出异常信息
     * @param <T> 泛型
     * @throws IllegalStateException 异常信息
     */
    public static <T> void isInstanceOf(Class<?> type, T obj, String message) {
        notNull(type, "要检查的类型,不能为空");
        if (!type.isInstance(obj)) {
            throw new IllegalArgumentException(message);
        }
    }

    private AssertUtils(){}
}

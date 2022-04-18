package cn.lenjoy.boot.framework.common.util.function;

import java.util.function.Predicate;

/**
 * @description: 断言式接口，返回值为 boolean
 * 1。断言是都为空等
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 18 星期一
 * @version: 1.0.0
 */
@FunctionalInterface
public interface IPredicate<T> extends Predicate<T> {
    /**
     * 根据给定参数评估此谓词是否匹配
     * @param t 输入参数
     * @return 如果输入参数与谓词匹配，则为 true，否则为 false
     */
    boolean test(T t);
}

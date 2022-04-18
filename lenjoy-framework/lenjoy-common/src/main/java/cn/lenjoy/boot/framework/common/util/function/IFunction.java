package cn.lenjoy.boot.framework.common.util.function;

import java.util.function.Function;

/**
 * @description: 函数式接口，有入参有返回值
 * 1.组装转换数据
 * 2.自定义stream操作
 * 3.判断对象空否，空则返回默认值，否则返回操作对象结果
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 18 星期一
 * @version: 1.0.0
 */
@FunctionalInterface
public interface IFunction<T, R> extends Function<T, R> {
    /**
     * 返回结果
     * @param t 参数
     * @return 结果
     */
    R apply(T t);
}

package cn.lenjoy.boot.framework.common.util.function;

import java.util.function.Supplier;

/**
 * @description: 生产者接口，有返回值
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 18 星期一
 * @version: 1.0.0
 */
@FunctionalInterface
public interface ISupplier<T> extends Supplier<T> {
    /**
     * 得到结果
     * @return 结果
     */
    T get();
}

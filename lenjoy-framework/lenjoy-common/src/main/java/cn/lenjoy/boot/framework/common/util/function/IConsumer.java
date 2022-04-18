package cn.lenjoy.boot.framework.common.util.function;

import java.util.function.Consumer;

/**
 * @description: 消费者接口，无返回值
 * 1.执行类接口
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 18 星期一
 * @version: 1.0.0
 */
@FunctionalInterface
public interface IConsumer<T> extends Consumer<T> {
    /**
     * 对给定参数执行此操作
     * @param t 参数
     */
    void accept(T t);
}

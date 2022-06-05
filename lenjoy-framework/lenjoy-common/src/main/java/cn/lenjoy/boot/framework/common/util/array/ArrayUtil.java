package cn.lenjoy.boot.framework.common.util.array;

/**
 * @description: Array 工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class ArrayUtil {

    private ArrayUtil() {}

    /**
     * 数组是否为非空
     * @param array 数组
     * @param <T> 泛型
     * @return 是否为空
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return array != null && array.length != 0;
    }
}

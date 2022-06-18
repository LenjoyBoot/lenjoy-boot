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
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为空
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(Object[] array) { return array == null || array.length == 0; }

    /**
     * 是否为数组
     * @param obj 对象
     * @return 是否为数组
     */
    public static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }
}

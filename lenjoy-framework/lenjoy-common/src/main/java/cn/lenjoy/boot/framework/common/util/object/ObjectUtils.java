package cn.lenjoy.boot.framework.common.util.object;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @description: Object 工具类
 * @author: bincloud, mvpzhou
 * @date: Create By bincloud, mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class ObjectUtils {

    /**
     * class NULL
     */
    public static class Null implements Serializable {
        private static final Null INSTANCE = new Null();
        private Null() {}
        public static Null getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 对象是否相等
     *
     * @param obj1 对象1
     * @param obj2 对象2
     * @return 对象是否相等
     */
    public static boolean equals(final Object obj1, final Object obj2) {
        return Objects.equals(obj1, obj2);
    }

    /**s
     * 对象是否不为空
     * 1.null
     * 2.""
     * 3.new int[]{} Arrays
     * 4.new Collection()
     * 5.new Map()
     *
     * @param obj 对象
     * @return 是否不为空对象
     */
    public static boolean isNotEmpty(final Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 对象是否为空
     * 1.null
     * 2.""
     * 3.new int[]{} Arrays
     * 4.new Collection()
     * 5.new Map()
     *
     * @param obj 对象
     * @return 是否为空对象
     */
    public static boolean isEmpty(final Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof Optional) {
            return !((Optional<?>)obj).isPresent();
        } else if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        } else if (obj instanceof Collection<?>) {
            return ((Collection<?>) obj).isEmpty();
        } else if (obj instanceof Map<?, ?>) {
            return ((Map<?, ?>) obj).isEmpty();
        } else {
            return false;
        }
    }

    /**
     * 是否不为 null
     *
     * @param obj 对象
     * @return 是否不为 null
     */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    /**
     * 是否 null
     *
     * @param obj 对象
     * @return 是否 null
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 私有构造方法
     */
    private ObjectUtils() {}
}

package cn.lenjoy.boot.framework.common.util.string;

/**
 * @description: String 工具类
 * @author: bincloud, mvpzhou
 * @date: Create By bincloud, mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class StringUtils {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    /**
     * 私有构造方法
     */
    private StringUtils() {}

    /**
     * 字符串是否相等
     *
     * @param cs1 字符串1
     * @param cs2 字符串2
     * @return 字符串是否相等
     */
    public static boolean isNotEquals(final CharSequence cs1, final CharSequence cs2) {
        return !isEquals(cs1, cs2);
    }

    /**
     * 字符串是否相等
     *
     * @param cs1 字符串1
     * @param cs2 字符串2
     * @return 字符串是否相等
     */
    public static boolean isEquals(final CharSequence cs1, final CharSequence cs2) {
        if (cs1 == cs2) {
            return true;
        }
        if (cs1 == null || cs2 == null) {
            return false;
        }
        if (cs1.length() != cs2.length()) {
            return false;
        }
        if (cs1 instanceof String && cs2 instanceof String) {
            return cs1.equals(cs2);
        }
        // 非String
        final int len = cs1.length();
        for (int i = 0; i < len; i++) {
            if (cs1.charAt(i) != cs2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串是否不为空
     * 1.null
     * 2.""
     * 3." "
     *
     * @param cs 字符串
     * @return 是否不为空字符串
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 字符串是否为空
     * 1.null
     * 2.""
     * 3." "
     *
     * @param cs 字符串
     * @return 是否为空字符串
     */
    public static boolean isBlank(final CharSequence cs) {
        final int len = length(cs);
        if (len == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串是否不为空
     * 1.null
     * 2.""
     *
     * @param cs 字符串
     * @return 是否不为空字符串
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 字符串是否为空
     * 1.null
     * 2.""
     *
     * @param cs 字符串
     * @return 是否为空字符串
     */
    public static boolean isEmpty(final CharSequence cs) {
        return isNull(cs) || cs.length() == 0;
    }

    /**
     * 字符串长度
     *
     * @param cs 字符串
     * @return 字符串长度
     */
    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    /**
     * 对象是否为空
     *
     * @param obj 对象
     * @return 是否为空
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 字符串转字符串数组,通过分隔符
     *
     * @param str 字符串
     * @param delimiter 分隔符
     * @return 字符串数组
     */
    public static String[] stringToStringArray(String str, String delimiter) {
        return str.split(delimiter);
    }

    /**
     * 字符串数组转字符串,通过分隔符
     *
     * @param str 字符串数组
     * @param delimiter 分隔符
     * @return 字符串
     */
    public static String stringToStringArray(String delimiter, String... str) {
        return String.join(delimiter, str);
    }

    /**
     * 字符串数组转字符串,通过分隔符
     *
     * @param str 字符串数组
     * @param delimiter 分隔符
     * @return 字符串
     */
    public static String stringToStringArray(String[] str, String delimiter) {
        return String.join(delimiter, str);
    }
}

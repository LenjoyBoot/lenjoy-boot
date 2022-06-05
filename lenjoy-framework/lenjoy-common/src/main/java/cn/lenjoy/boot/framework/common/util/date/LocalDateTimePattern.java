package cn.lenjoy.boot.framework.common.util.date;

import java.util.regex.Pattern;

/**
 * @description: LocalDateTime 格式化类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class LocalDateTimePattern {

    private LocalDateTimePattern() {}

    /**
     * 标准日期时间正则表达式：
     * <pre>
     *     yyyy-MM-dd'T'HH:mm:ss.SSS
     *     yyyy-MM-dd'T'HH:mm:ss
     *     yyyy-MM-dd'T'HH:mm
     *     yyyy-MM-dd
     * </pre>
     */
    public static final Pattern REGEX_NORM = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}(T\\d{1,2}:\\d{1,2}(:\\d{1,2})?)?(.\\d{1,3})?");

    /**
     * 标准日期时间正则表达式,毫秒
     * <pre>
     *     yyyy-MM-dd'T'HH:mm:ss.SSS+SSSS
     * </pre>
     */
    public static final Pattern REGEX_NORM_MILL = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}T\\d{1,2}:\\d{1,2}(:\\d{1,2}).\\d{1,3}\\+\\d{1,4}");

    /**
     * 是否为标准时间格式
     * @param localDateTimeStr LocalDateTime 时间字符串
     * @return 是否为标准时间格式
     */
    public static boolean isLocalDateTimePattern(String localDateTimeStr) {
        return isLocalDateTimeNormPattern(localDateTimeStr) || isLocalDateTimeMillPattern(localDateTimeStr);
    }

    /**
     * 是否为标准时间格式
     * @param localDateTimeStr LocalDateTime 时间字符串
     * @return 是否为标准时间格式
     */
    public static boolean isLocalDateTimeMillPattern(String localDateTimeStr) {
        return REGEX_NORM_MILL.matcher(localDateTimeStr).matches();
    }

    /**
     * 是否为标准时间格式
     * @param localDateTimeStr LocalDateTime 时间字符串
     * @return 是否为标准时间格式
     */
    public static boolean isLocalDateTimeNormPattern(String localDateTimeStr) {
        return REGEX_NORM.matcher(localDateTimeStr).matches();
    }

}

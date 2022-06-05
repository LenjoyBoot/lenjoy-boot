package cn.lenjoy.boot.framework.common.util.date;

import java.util.regex.Pattern;

/**
 * @description: Date 格式化类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class DatePattern {

    private DatePattern() {}

    /**
     * 标准日期时间正则表达式,支持毫秒
     * <pre>
     *     yyyy-MM-dd HH:mm:ss.SSSSSS
     *     yyyy-MM-dd HH:mm:ss.SSS
     *     yyyy-MM-dd HH:mm:ss
     *     yyyy-MM-dd HH:mm
     *     yyyy-MM-dd
     * </pre>
     */
    public static final Pattern REGEX_NORM = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}(\\s\\d{1,2}:\\d{1,2}(:\\d{1,2})?)?(.\\d{1,6})?");

    /**
     * 是否为标准时间格式
     * @param dateStr Date 时间字符串
     * @return 是否为标准时间格式
     */
    public static boolean isLocalDateTimePattern(String dateStr) {
        return REGEX_NORM.matcher(dateStr).matches();
    }

}

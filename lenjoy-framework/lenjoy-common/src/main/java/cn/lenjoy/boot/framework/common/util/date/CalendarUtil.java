package cn.lenjoy.boot.framework.common.util.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @description: Calendar 工具类 {@link Calendar}
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class CalendarUtil {

    private CalendarUtil() {}

    /**
     * 当前时间，默认时区
     * @return Calendar 类
     */
    public static Calendar calendar() {
        return Calendar.getInstance();
    }

    /**
     * Date 类 转换为 Calendar 类
     * @param date 日期对象
     * @return Calendar 类
     */
    public static Calendar calendar(Date date) {
        return calendar(date.getTime());
    }

    /**
     * 根据时间戳 转换为 Calendar 类
     * @param timestamp 时间戳
     * @return Calendar 类
     */
    public static Calendar calendar(long timestamp) {
        final Calendar cal = calendar();
        cal.setTimeInMillis(timestamp);
        return cal;
    }

}

package cn.lenjoy.boot.framework.common.util.date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * @description: LocalDateTime 工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class LocalDateTimeUtils {

    /**
     * 私有构造数
     */
    private LocalDateTimeUtils() {}

    /**
     * 当前时间，默认时区
     * @return LocalDateTime 类
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * 当前时间日期偏移,根据 field 单位 秒
     * @param timeout 整数 加，负数 减
     * @return 偏移后的日期
     */
    public static LocalDateTime offset(long timeout) {
        return offset(now(), timeout, ChronoUnit.SECONDS);
    }

    /**
     * 当前时间日期偏移,根据 field 单位
     * @param timeout 整数 加，负数 减
     * @param unit 单位
     * @return 偏移后的日期
     */
    public static LocalDateTime offset(long timeout, TemporalUnit unit) {
        return offset(now(), timeout, unit);
    }

    /**
     * 日期偏移,根据 field 单位
     * @param time 日期基础
     * @param timeout 整数 加，负数 减
     * @param unit 单位
     * @return 偏移后的日期
     */
    public static LocalDateTime offset(LocalDateTime time, long timeout, TemporalUnit unit) {
        if (time == null) {
            return null;
        }
        return time.plus(timeout, unit);
    }
}

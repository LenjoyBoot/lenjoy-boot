package cn.lenjoy.boot.framework.common.util.date;

import java.util.Date;

/**
 * @description: Date 工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class DateUtils {

    private DateUtils() {}

    /**
     * 当前时间，默认时区
     * @return Date 类
     */
    public static Date now() {
        return new Date();
    }


}

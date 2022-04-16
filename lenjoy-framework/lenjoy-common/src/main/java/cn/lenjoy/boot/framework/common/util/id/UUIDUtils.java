package cn.lenjoy.boot.framework.common.util.id;

import java.util.UUID;

/**
 * @description: ID 工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class UUIDUtils {

    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public static String simpleUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 私有构造方法
     */
    private UUIDUtils() {}
}

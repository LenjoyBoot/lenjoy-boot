package cn.lenjoy.boot.framework.common.util.random;

import java.security.SecureRandom;

/**
 * @description: 随机生成工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
public class RandomUtils {
    public static final SecureRandom RANDOM = new SecureRandom();

    /**
     * [N1,N2) 之间的随机数
     * @param start 起始值
     * @param end 结束值
     * @return 随机数
     */
    public static int nextInt(int start, int end){
        return Math.min(start, end) + nextInt(Math.abs(start - end));
    }

    /**
     * [0,N) 之间的随机数
     * @param end 结束值
     * @return 随机数
     */
    public static int nextInt(int end){
        return RANDOM.nextInt(end);
    }

    /**
     * 私有构造方法
     */
    private RandomUtils() {}
}

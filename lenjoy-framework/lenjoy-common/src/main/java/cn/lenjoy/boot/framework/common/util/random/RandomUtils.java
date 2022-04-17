package cn.lenjoy.boot.framework.common.util.random;

import java.security.SecureRandom;

import static cn.lenjoy.boot.framework.common.constant.CharConstant.*;

/**
 * @description: 随机生成工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class RandomUtils {
    public static final SecureRandom RANDOM = new SecureRandom();

    /**
     * 繁体中文数字随机数
     * @param length 长度
     * @return 随机数
     */
    public static String nextNumberTC(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(nextNumberTC());
        }
        return sb.toString();
    }

    /**
     * 繁体中文数字随机数
     * @return 随机数
     */
    public static char nextNumberTC(){
        return getNumberTc()[nextInt(10)];
    }

    /**
     * 简体中文数字随机数
     * @param length 长度
     * @return 随机数
     */
    public static String nextNumberCn(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(nextNumberCn());
        }
        return sb.toString();
    }

    /**
     * 简体中文数字随机数
     * @return 随机数
     */
    public static char nextNumberCn(){
        return getNumberCn()[nextInt(10)];
    }

    /**
     * 数字字母随机数
     * @param length 长度
     * @return 数字随机数
     */
    public static String nextNumberLetter(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(nextNumberLetter());
        }
        return sb.toString();
    }

    /**
     * 数字字母随机数
     * @return 随机数
     */
    public static char nextNumberLetter(){
        return getNumberLetter()[nextInt(62)];
    }

    /**
     * 字母随机数
     * @param length 长度
     * @return 数字随机数
     */
    public static String nextLetter(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(nextLetter());
        }
        return sb.toString();
    }

    /**
     * 字母随机数
     * @return 随机数
     */
    public static char nextLetter(){
        return getLetter()[nextInt(26)];
    }

    /**
     * 大写字母随机数
     * @param length 长度
     * @return 数字随机数
     */
    public static String nextUpper(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(nextUpper());
        }
        return sb.toString();
    }

    /**
     * 大写字母随机数
     * @return 随机数
     */
    public static char nextUpper(){
        return getUpper()[nextInt(26)];
    }

    /**
     * 小写字母随机数
     * @param length 长度
     * @return 随机数
     */
    public static String nextLower(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(nextLower());
        }
        return sb.toString();
    }

    /**
     * 小写字母随机数
     * @return 随机数
     */
    public static char nextLower(){
        return getLower()[nextInt(26)];
    }

    /**
     * 数字随机数
     * @param length 长度
     * @return 随机数
     */
    public static String nextNumber(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(nextNumber());
        }
        return sb.toString();
    }

    /**
     * 数字随机数
     * @return 随机数
     */
    public static char nextNumber(){
        return getNumber()[nextInt(10)];
    }

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

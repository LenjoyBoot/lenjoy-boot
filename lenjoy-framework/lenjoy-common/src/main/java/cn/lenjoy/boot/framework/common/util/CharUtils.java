package cn.lenjoy.boot.framework.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 字符工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
public class CharUtils {
    // 简体 一 二 三 四 五 六 七 八 九 零
    private static final char[] CHINESE_NUMBER_CN_CHAR = { '\u4e00', '\u4e8c', '\u4e09', '\u56db', '\u4e94', '\u516d', '\u4e03', '\u516b', '\u4e5d', '\u96f6' };
    // 繁体 壹 贰 叁 肆 伍 陆 柒 捌 玖 零
    private static final char[] CHINESE_NUMBER_TC_CHAR = { '\u58f9', '\u8d30', '\u53c1', '\u8086', '\u4f0d', '\u9646', '\u67d2', '\u634c', '\u7396', '\u96f6' };
    // 运算符
    private static final char[] OPERATOR_CHAR = { '+', '-', '*', 'x' };

    // 0-9
    private static final List<String> NUMBER = new ArrayList<>();
    // a-z 小写
    private static final List<String> LOWER = new ArrayList<>();
    // A-Z 大写
    private static final List<String> UPPER = new ArrayList<>();
    // 0-9a-zA-Z
    private static final List<String> LETTER = new ArrayList<>();
    // 简体 一 二 三 四 五 六 七 八 九 零
    private static final List<String> CHINESE_NUMBER_CN = new ArrayList<>();
    // 繁体 壹 贰 叁 肆 伍 陆 柒 捌 玖 零
    private static final List<String> CHINESE_NUMBER_TC = new ArrayList<>();
    // 运算符
    private static final List<String> OPERATOR = new ArrayList<>();

    static {
        // 数字
        for (int i = '0'; i <= '9'; i++) {
            NUMBER.add(String.valueOf(i));
        }
        // 小写
        for (int i = 'a'; i <= 'z'; i++) {
            LOWER.add(String.valueOf(i));
        }
        // 大写
        for (int i = 'A'; i <= 'Z'; i++) {
            UPPER.add(String.valueOf(i));
        }
        // 大小写
        LETTER.addAll(LOWER);
        LETTER.addAll(UPPER);
        // 正文简体数字
        for (char ch : CHINESE_NUMBER_CN_CHAR) {
            CHINESE_NUMBER_CN.add(String.valueOf(ch));
        }
        // 正文繁体数字
        for (char ch : CHINESE_NUMBER_TC_CHAR) {
            CHINESE_NUMBER_TC.add(String.valueOf(ch));
        }
        // 运算符
        for (char ch : OPERATOR_CHAR) {
            OPERATOR.add(String.valueOf(ch));
        }
    }

    public static List<String> getNumber() {
        return NUMBER;
    }

    public static List<String> getLower() {
        return LOWER;
    }

    public static List<String> getUpper() {
        return UPPER;
    }

    public static List<String> getLetter() {
        return LETTER;
    }

    public static List<String> getChineseNumberCn() {
        return CHINESE_NUMBER_CN;
    }

    public static List<String> getChineseNumberTc() {
        return CHINESE_NUMBER_TC;
    }

    public static List<String> getOperator() {
        return OPERATOR;
    }

    /**
     * 私有构造方法
     */
    private CharUtils() {}
}

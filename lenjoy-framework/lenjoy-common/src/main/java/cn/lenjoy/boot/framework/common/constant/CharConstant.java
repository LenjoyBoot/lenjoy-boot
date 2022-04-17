package cn.lenjoy.boot.framework.common.constant;

/**
 * @description: 常用字符常量
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class CharConstant {

    public static char[] getNumber() {
        return NUMBER;
    }

    public static char[] getLower() {
        return LOWER;
    }

    public static char[] getUpper() {
        return UPPER;
    }

    public static char[] getNumberCn() {
        return NUMBER_CN;
    }

    public static char[] getNumberTc() {
        return NUMBER_TC;
    }

    public static char[] getLetter() {
        return LETTER;
    }

    public static char[] getNumberLetter() {
        return NUMBER_LETTER;
    }

    private static final char[] NUMBER = {
        '1','2','3','4','5','6','7','8','9','0'
    };

    private static final char[] LOWER = {
        'a','b','c','d','e','f','g','h',
        'i','j','k','l','m','n','o','p',
        'q','r','s','t','u','v','w','x',
        'y','z'
    };

    private static final char[] UPPER = {
        'A','B','C','D','E','F','G','H',
        'I','J','K','L','M','N','O','P',
        'Q','R','S','T','U','V','W','X',
        'Y','Z'
    };

    private static final char[] LETTER = {
        'a','b','c','d','e','f','g','h',
        'i','j','k','l','m','n','o','p',
        'q','r','s','t','u','v','w','x',
        'y','z',
        'A','B','C','D','E','F','G','H',
        'I','J','K','L','M','N','O','P',
        'Q','R','S','T','U','V','W','X',
        'Y','Z'
    };

    private static final char[] NUMBER_LETTER = {
        '1','2','3','4','5','6','7','8','9','0',
        'a','b','c','d','e','f','g','h',
        'i','j','k','l','m','n','o','p',
        'q','r','s','t','u','v','w','x',
        'y','z',
        'A','B','C','D','E','F','G','H',
        'I','J','K','L','M','N','O','P',
        'Q','R','S','T','U','V','W','X',
        'Y','Z'
    };

    private static final char[] NUMBER_CN = {
        '\u4e00','\u4e8c','\u4e09','\u56db','\u4e94','\u516d','\u4e03','\u516b','\u4e5d','\u96f6'
    };

    private static final char[] NUMBER_TC = {
        '\u58f9','\u8d30','\u53c1','\u8086','\u4f0d','\u9646','\u67d2','\u634c','\u7396','\u96f6'
    };

    /**
     * 私有构造函数
     */
    private CharConstant() {}

}

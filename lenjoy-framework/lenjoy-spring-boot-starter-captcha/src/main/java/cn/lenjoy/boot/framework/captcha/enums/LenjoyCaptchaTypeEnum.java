package cn.lenjoy.boot.framework.captcha.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 图形验证码类型枚举
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum LenjoyCaptchaTypeEnum {
    /**
     * 验证码类型
     */
    DEFAULT(0, "默认,数字&大写字母&小写字母"),
    NUMBER(1, "数字"),
    UPPER(2, "大写字母"),
    LOWER(3, "小写字母"),
    LETTER(4, "大写字母&小写字母"),
    NUMBER_CN(5, "简体中文数字"),
    NUMBER_TC(6, "繁体中文数字"),
    ARITHMETIC(7, "算术"),
    CHINESE_CN(8, "简体中文"),
    CHINESE_TC(9, "繁体中文"),
    // 0-100 x轴
    PROGRESS_BAR(10, "进度条"),
    // 0-x x轴
    SLIDER(11, "滑块"),
    // 随机坐标 x轴 y轴
    COORDINATE(12, "坐标,数字&大写字母&小写字母"),
    COORDINATE_CN(13, "坐标,简体中文"),
    COORDINATE_TC(14, "坐标,繁体中文"),
    COORDINATE_IDIOM_CN(15, "坐标,简体成语"),
    COORDINATE_IDIOM_TC(16, "坐标,繁体成语"),
    // 图片随机
    SINGLE_CORRECT_PIC(17, "单张正确图片"),
    MULTIPLE_CORRECT_PIC(18, "多张正确图片"),
    // 旋转图片 0~360°
    ROTATE_CORRECT_PIC(18, "旋转正确图片"),

    ;

    private final Integer code;
    private final String desc;

    public static boolean noType(Integer code) {
        return !hasType(code);
    }

    public static boolean hasType(Integer code) {
        for (LenjoyCaptchaTypeEnum value : LenjoyCaptchaTypeEnum.values()) {
            if (value.code.equals(code)) {
                return true;
            }
        }
        return false;
    }
}

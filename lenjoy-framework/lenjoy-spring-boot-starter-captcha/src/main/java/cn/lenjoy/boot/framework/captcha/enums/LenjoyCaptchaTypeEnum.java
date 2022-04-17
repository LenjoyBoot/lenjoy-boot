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
    //默认,数字
    DEFAULT,
    // 数字
    NUMBER,
    // 大写字母
    UPPER,
    // 小写字母
    LOWER,
    // 大写字母&小写字母
    LETTER,
    // 数字&大写字母&小写字母
    NUMBER_LETTER,
    // 简体中文数字
    NUMBER_CN,
    // 繁体中文数字
    NUMBER_TC,
    // 算术
    ARITHMETIC,
    // 简体中文
    CHINESE_CN,
    // 繁体中文
    CHINESE_TC,
    // 进度条 0%-100% x轴
    PROGRESS_BAR,
    // 滑块 0-x x轴
    SLIDER,
    // 坐标,数字&大写字母&小写字母 随机坐标 x轴 y轴
    COORDINATE,
    // 坐标,简体中文
    COORDINATE_CN,
    // 坐标,繁体中文
    COORDINATE_TC,
    // 坐标,简体成语
    COORDINATE_IDIOM_CN,
    // 坐标,繁体成语
    COORDINATE_IDIOM_TC,
    // 单张正确图片 图片随机
    SINGLE_CORRECT_PIC,
    // 多张正确图片
    MULTIPLE_CORRECT_PIC,
    // 旋转正确图片 旋转图片 0~360°
    ROTATE_CORRECT_PIC
}

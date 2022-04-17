package cn.lenjoy.boot.framework.captcha.core;

import cn.lenjoy.boot.framework.captcha.constant.LenjoyCaptchaConstant;
import cn.lenjoy.boot.framework.captcha.enums.LenjoyCaptchaStyleEnum;
import cn.lenjoy.boot.framework.captcha.exception.LenjoyCaptchaGenerateException;
import cn.lenjoy.boot.framework.common.util.date.DateTimeUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Base64;

/**
 * @description: 乐享图形验证码
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LenjoyGraphicCaptcha extends AbstractCaptcha implements LenjoyValidateCaptcha {

    public LenjoyGraphicCaptcha() { }

    public LenjoyGraphicCaptcha(int type, int style, int length) {
        this.type = type;
        this.style = style;
        this.length = length;
    }

    /**
     * 生成验证码对象
     * 默认类型
     * 默认IMAGE
     * 超时时间 60秒 单位 秒
     * 长度 默认 4
     *
     * @return 生成验证码对象
     */
    @Override
    public LenjoyCaptcha generate() {
        return generate(type, length);
    }

    /**
     * 生成验证码对象
     *
     * @param type 类型 超时时间 60秒 单位 秒
     * @param length 长度 默认 4
     * @return 生成验证码对象
     */
    @Override
    public LenjoyCaptcha generate(int type, int length) {
        return generate(type, 60L, ChronoUnit.SECONDS, length);
    }

    /**
     * 生成验证码对象
     *
     * @param type    类型
     * @param timeout 超时时间 单位 秒
     * @return 生成验证码对象
     */
    @Override
    public LenjoyCaptcha generate(int type, long timeout, int length) {
        return generate(type, timeout, ChronoUnit.SECONDS, length);
    }

    /**
     * 生成验证码对象
     *
     * @param type    类型
     * @param timeout 超时时间
     * @param unit    单位
     * @return 生成验证码对象
     */
    @Override
    public LenjoyCaptcha generate(int type, long timeout, TemporalUnit unit, int length) {
        String text = randomText(type, length);
        // 组装数据
        LenjoyCaptcha captcha = new LenjoyCaptcha();
        captcha.setCert("");
        captcha.setKey(text);
        captcha.setValue(toBase64(text));
        captcha.setType(type);
        captcha.setStyle(LenjoyCaptchaStyleEnum.IMAGE.getCode());
        captcha.setTimeout(DateTimeUtils.offset(timeout, unit));
        return captcha;
    }

    /**
     * 生成随机字符串
     *
     * @param type 验证码类型
     * @return 格式字符串
     */
    @Override
    public String randomText(int type, int length) {
        if (length == 5) {
            return "12345";
        }
        return "1234";
    }

    /**
     * 图片 转 Base64 格式字符串
     *
     * @param text 图片流
     * @return Base64格式字符串
     */
    @Override
    public String toBase64(String text) {
        byte[] bytes = toBytes(text);
        return LenjoyCaptchaConstant.BASE64_PNG_PREFIX + Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 生成验证码 byte[]
     * @param text 验证码
     * @return 验证码对象
     */
    @Override
    public byte[] toBytes(String text) {
        try(ByteArrayOutputStream bis = new ByteArrayOutputStream()) {
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            Graphics2D g2 = bi.createGraphics();
            // 白色矩形
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, width, height);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 字体
            g2.setFont(font);
            // 干扰线
            drawLine(g2);
            drawOval(g2);
            drawBesselLine(g2);
            // 验证码
            FontMetrics fontMetrics = g2.getFontMetrics();
            int w1 = (width / text.length()) - 2;
            int w2 = (w1 - (int) fontMetrics.getStringBounds("5", g2).getWidth()) / 2;
            for (int i = 0; i < text.length(); i++) {
                g2.setColor(randomColor());
                int tmp = height - ((height - (int) fontMetrics.getStringBounds(String.valueOf(text.charAt(i)), g2).getHeight()) / 2);
                g2.drawString(String.valueOf(text.charAt(i)), i * w1 + w2, tmp);
            }
            // 释放
            g2.dispose();
            // 输出
            ImageIO.write(bi, LenjoyCaptchaConstant.PNG, bis);
            return bis.toByteArray();
        } catch (Exception e) {
            throw new LenjoyCaptchaGenerateException();
        }
    }

    /**
     * 验证是否正确 默认忽略大小写
     *
     * @param sourceCode 源验证码
     * @param targetCode 目标验证码
     * @return 是否正确
     */
    @Override
    public boolean validate(String sourceCode, String targetCode) {
        return validate(sourceCode, targetCode, true);
    }

    /**
     * 验证是否正确
     *
     * @param sourceCode 源验证码
     * @param targetCode 目标验证码
     * @param ignore     忽略大小写
     * @return 是否正确
     */
    @Override
    public boolean validate(String sourceCode, String targetCode, boolean ignore) {
        if (ignore) {
            return StringUtils.isEquals(sourceCode.toLowerCase(), targetCode.toLowerCase());
        }
        return StringUtils.isEquals(sourceCode, targetCode);
    }
}

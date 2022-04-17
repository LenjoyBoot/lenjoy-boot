package cn.lenjoy.boot.framework.captcha.core;

import cn.lenjoy.boot.framework.captcha.enums.LenjoyCaptchaStyleEnum;
import cn.lenjoy.boot.framework.captcha.enums.LenjoyCaptchaTypeEnum;

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.QuadCurve2D;

import static cn.lenjoy.boot.framework.common.util.random.RandomUtils.nextInt;

/**
 * @description: 抽象验证码
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public abstract class AbstractCaptcha {
    private static final int START = 0;
    private static final int END = 256;

    //验证码字体
    protected Font font = new Font("Default", Font.PLAIN, 24);
    //验证码图片默认宽度
    protected int width = 160;
    //验证码图片默认高度
    protected int height = 40;
    //验证码类型
    protected LenjoyCaptchaTypeEnum type = LenjoyCaptchaTypeEnum.DEFAULT;
    //验证码类型
    protected LenjoyCaptchaStyleEnum style = LenjoyCaptchaStyleEnum.IMAGE;
    //验证码默认长度 4
    protected int length = 4;
    //验证码默认超时 60
    protected long timeout = 60L;

    protected AbstractCaptcha() { }

    /**
     * 生成验证码对象
     * @return 生成验证码对象
     */
    public abstract LenjoyCaptcha generate();

    /**
     * 生成随机字符串
     * @param type 验证码类型
     * @return 格式字符串
     */
    public abstract String randomText(LenjoyCaptchaTypeEnum type, int length);

    /**
     * 图片 转 Base64 格式字符串
     * @param text 验证码
     * @return Base64 格式字符串
     */
    public abstract String toBase64(String text);

    /**
     * 生成验证码
     * @param text 验证码字符串
     * @return 验证码对象
     */
    public abstract byte[] toBytes(String text);

    /**
     * RGB 颜色
     * 有效颜色
     * @return 返回随机颜色
     */
    protected Color randomColor() {
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = nextInt(START, END);
        }
        return new Color(rgb[0], rgb[1], rgb[2]);
    }

    /**
     * 画干扰线
     * @param count 数量
     * @param bold 粗细
     * @param g2 画布
     */
    protected void drawLine(int count, int bold, Graphics2D g2) {
        g2.setStroke(new BasicStroke(bold));
        drawLine(count, randomColor(), g2);
    }

    /**
     * 画干扰线
     * @param g2 画布
     */
    protected void drawLine(Graphics2D g2) {
        drawLine(nextInt(2, 5), g2);
    }

    /**
     * 画干扰线
     * @param count 数量
     * @param g2 画布
     */
    protected void drawLine(int count, Graphics2D g2) {
        drawLine(count, null, g2);
    }

    /**
     * 画干扰线
     * @param count 数量
     * @param color 颜色
     * @param g2 画布
     */
    protected void drawLine(int count, Color color, Graphics2D g2) {
        for (int i = 0; i < count; i++) {
            g2.setColor(color == null ? randomColor() : color);
            int x1 = nextInt(-10, width - 10);
            int y1 = nextInt(5, height - 5);
            int x2 = nextInt(10, width + 10);
            int y2 = nextInt(2, height - 2);
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 画圆
     * @param count 数量
     * @param bold 粗细
     * @param g2 画布 单
     */
    protected void drawOval(int count, int bold, Graphics2D g2) {
        g2.setStroke(new BasicStroke(bold));
        drawOval(count, randomColor(), g2);
    }

    /**
     * 画圆
     * @param g2 画布
     */
    protected void drawOval(Graphics2D g2) {
        drawOval(nextInt(1, 3), g2);
    }

    /**
     * 画圆
     * @param count 数量
     * @param g2 画布
     */
    protected void drawOval(int count, Graphics2D g2) {
        drawOval(count, null, g2);
    }

    /**
     * 画圆
     * @param count 数量
     * @param color 颜色
     * @param g2 画布
     */
    protected void drawOval(int count, Color color, Graphics2D g2) {
        for (int i = 0; i < count; i++) {
            g2.setColor(color == null ? randomColor() : color);
            int w = 5 + nextInt(10);
            g2.drawOval(nextInt(width - 25), nextInt(height - 15), w, w);
        }
    }

    /**
     * 画贝塞尔曲线
     * @param count 数量
     * @param bold 粗细
     * @param g2 画布
     */
    public void drawBesselLine(int count, int bold, Graphics2D g2) {
        g2.setStroke(new BasicStroke(bold));
        drawBesselLine(count, randomColor(), g2);
    }

    /**
     * 画贝塞尔曲线
     */
    public void drawBesselLine(Graphics2D g2) {
        drawBesselLine(nextInt(2, 5), g2);
    }

    /**
     * 画贝塞尔曲线
     * @param count 数量
     * @param g2 画布
     */
    public void drawBesselLine(int count, Graphics2D g2) {
        drawBesselLine(count, null, g2);
    }

    /**
     * 画贝塞尔曲线
     * @param count 数量
     * @param color 颜色
     * @param g2 画布
     */
    public void drawBesselLine(int count, Color color, Graphics2D g2) {
        for (int i = 0; i < count; i++) {
            g2.setColor(color == null ? randomColor() : color);
            int x1 = 5;
            int y1 = nextInt(5, height / 2);
            int x2 = width - 5;
            int y2 = nextInt(height / 2, height - 5);
            int cx = nextInt(width / 4, width / 4 * 3);
            int cy = nextInt(5, height - 5);
            // 随机数
            if (nextInt(2) == 0) {
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            // 二阶贝塞尔曲线
            if (nextInt(2) == 0) {
                QuadCurve2D shape = new QuadCurve2D.Double();
                shape.setCurve(x1, y1, cx, cy, x2, y2);
                g2.draw(shape);
            } else {
                // 三阶贝塞尔曲线
                int tmpcx = nextInt(width / 4, width / 4 * 3);
                int tmpcy = nextInt(5, height - 5);
                CubicCurve2D shape = new CubicCurve2D.Double(x1, y1, cx, cy, tmpcx, tmpcy, x2, y2);
                g2.draw(shape);
            }
        }
    }
}

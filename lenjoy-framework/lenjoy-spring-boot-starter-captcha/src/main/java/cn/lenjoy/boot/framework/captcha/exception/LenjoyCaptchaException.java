package cn.lenjoy.boot.framework.captcha.exception;

/**
 * @description: 验证码异常类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
public class LenjoyCaptchaException extends RuntimeException {

    public LenjoyCaptchaException() {
        super();
    }

    public LenjoyCaptchaException(Throwable cause) {
        super(cause);
    }
}

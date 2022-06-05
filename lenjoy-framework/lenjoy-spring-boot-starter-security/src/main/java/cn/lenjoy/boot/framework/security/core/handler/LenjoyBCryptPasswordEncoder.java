package cn.lenjoy.boot.framework.security.core.handler;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @description: 乐享 BCryptPasswordEncoder 加密
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
public class LenjoyBCryptPasswordEncoder extends BCryptPasswordEncoder implements PasswordEncoder {
}

package cn.lenjoy.boot.framework.security.core.service;

import cn.lenjoy.boot.framework.security.core.userdetails.LenjoyUserDetails;

/**
 * @description: LenjoyTokenVerifyTokenService token 验证接口
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 12 星期日
 * @version: 1.0.0
 */
public interface LenjoyTokenVerifyTokenService {

    /**
     * 校验 jwtToken，返回用户信息
     *
     * @param jwtToken token
     * @return 用户信息
     */
    LenjoyUserDetails verify(String jwtToken);
}

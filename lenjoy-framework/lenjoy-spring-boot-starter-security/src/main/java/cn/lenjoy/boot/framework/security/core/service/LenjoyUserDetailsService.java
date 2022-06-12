package cn.lenjoy.boot.framework.security.core.service;

import cn.lenjoy.boot.framework.common.enums.UserTypeEnum;
import cn.lenjoy.boot.framework.security.core.userdetails.LenjoyUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @description: 登录接口
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public interface LenjoyUserDetailsService extends UserDetailsService {

    /**
     * 校验 token 并刷新 token，返回用户信息
     *
     * @param token token
     * @return 用户信息
     */
    LenjoyUserDetails verifyTokenAndRefresh(String token);

    /**
     * 基于 token 退出登录
     *
     * @param token token
     */
    void logout(String token);

    /**
     * 获得用户类型
     *
     * @return 用户类型
     */
    UserTypeEnum getUserType();

}

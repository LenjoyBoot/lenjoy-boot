package cn.lenjoy.boot.framework.security.core.service;

import cn.lenjoy.boot.framework.common.enums.UserTypeEnum;
import cn.lenjoy.boot.framework.security.core.LenjoyUserDetails;
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
     * 校验 token，返回 用户信息
     * 若 token 失效，可刷新 token
     *
     * @param token token
     * @return 用户信息
     */
    LenjoyUserDetails verifyTokenAndRefresh(String token);

    /**
     * 模拟指定用户编号的用户信息
     *
     * @param userId 用户编号
     * @return 用户信息
     */
    LenjoyUserDetails mockLogin(Long userId);

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

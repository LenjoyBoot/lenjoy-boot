package cn.lenjoy.boot.framework.social.core.gitee;

import cn.lenjoy.boot.framework.social.core.LenjoySocialService;

/**
 * @description: 乐享社区 Gitee 接口
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public interface LenjoySocialGiteeService extends LenjoySocialService {

    /**
     * 获取 gitee 三方应用login uri
     * @return gitee 三方应用login uri
     */
    String loginUrl();

    // code

    /**
     * 根据回调授权码，二次验证社区登录成功（可根据token信息解析对象）
     * @param code 授权码（回调）
     * @return 是否登录成功
     */
    String token(String code);

    // email + password

    /**
     * 二次验证社区登录成功（可根据token信息解析对象）
     *
     * @param username 邮箱
     * @param password 密码
     * @return access_token
     */
    String token(String username, String password);

    // common

    /**
     * 根据 access_token 获取用户信息（可根据用户信息解析对象）
     * @param token 用户凭证（access_token）
     * @return 用户信息
     */
    String user(String token);

    /**
     * 根据 access_token 刷新token
     * @param token 用户凭证（access_token）
     * @return access_token
     */
    String refresh(String token);
}

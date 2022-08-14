package cn.lenjoy.boot.framework.social.core.gitee.impl;

import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.social.config.LenjoySocialGiteeProperties;
import cn.lenjoy.boot.framework.social.core.gitee.LenjoySocialGiteeService;
import cn.lenjoy.boot.framework.web.restemplate.util.RestTemplateUtils;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

import static cn.lenjoy.boot.framework.social.constant.LenjoySocialGiteeConstant.*;

/**
 * @description: 乐享社区 Gitee 接口实现
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@Slf4j
public class LenjoySocialGiteeServiceImpl implements LenjoySocialGiteeService {

    private final LenjoySocialGiteeProperties lenjoySocialGiteeProperties;

    public LenjoySocialGiteeServiceImpl(LenjoySocialGiteeProperties lenjoySocialGiteeProperties) {
        this.lenjoySocialGiteeProperties = lenjoySocialGiteeProperties;
    }

    @Resource
    private RestTemplateUtils restTemplateUtils;

    /**
     * 社交类型
     *
     * @return 社交类型
     */
    @Override
    public String type() {
        return "gitee";
    }

    /**
     * 社交验证
     *
     * @param code 授权码
     * @return 是否验证成功
     */
    @Override
    public boolean verify(String code) {
        return token(code) != null;
    }

    /**
     * 根据回调授权码，二次验证社区登录成功（可根据token信息解析对象）
     *
     * @param code 授权码（回调）
     * @return 是否登录成功
     */
    @Override
    public String token(String code) {
        // http 获取 token
        String body = restTemplateUtils.postString(tokenUrl(code));
        // 转换 body 获取 access_token
        String accessToken = JSON.parseObject(body).getString("access_token");
        AssertUtils.notNull(accessToken, "三方服务未授权，access_token不存在");
        return accessToken;
    }

    /**
     * 二次验证社区登录成功（可根据token信息解析对象）
     *
     * @param username 邮箱
     * @param password 密码
     * @return access_token
     */
    @Override
    public String token(String username, String password) {
        // http 获取 token
        // TODO 设置头部信息 Content-Type: application/x-www-form-urlencoded
        String body = restTemplateUtils.postString(TOKEN_PREFIX);
        // 转换 body 获取 access_token
        String accessToken = JSON.parseObject(body).getString("access_token");
        AssertUtils.notNull(accessToken, "三方服务未授权，access_token不存在");
        return accessToken;
    }

    /**
     * 根据 access_token 获取用户信息（可根据用户信息解析对象）
     *
     * @param token 用户凭证（access_token）
     * @return 用户信息
     */
    @Override
    public String user(String token) {
        // http 获取 token
        String body = restTemplateUtils.getString(userUrl(token));
        // 转换 body 获取 access_token
        String userId = JSON.parseObject(body).getString("id");
        AssertUtils.notNull(userId, "三方服务未授权，user id不存在");
        return userId;
    }

    /**
     * 根据 refresh_token 刷新token
     *
     * @param token 用户凭证（refresh_token）
     * @return access_token
     */
    @Override
    public String refresh(String token) {
        // http 获取 token
        String body = restTemplateUtils.postString(refreshUrl(token));
        // 转换 body 获取 access_token
        String accessToken = JSON.parseObject(body).getString("access_token");
        AssertUtils.notNull(accessToken, "三方服务未授权，access_token不存在");
        return accessToken;
    }

    /**
     * 获取 gitee 三方应用登录 uri
     *
     * @return gitee 三方应用登录 uri
     */
    @Override
    public String loginUrl() {
        return String.format(LOGIN_URL, lenjoySocialGiteeProperties.getClientId(), lenjoySocialGiteeProperties.getRedirectUrl());
    }

    // ==================== 通用方法 ====================

    private String tokenUrl(String socialCode) {
        return String.format(TOKEN_URL, socialCode, lenjoySocialGiteeProperties.getClientId(), lenjoySocialGiteeProperties.getRedirectUrl(), lenjoySocialGiteeProperties.getClientSecret());
    }

    private String userUrl(String accessToken) {
        return String.format(USER_URL, accessToken);
    }

    private String refreshUrl(String refreshToken) {
        return String.format(REFRESH_URL, refreshToken);
    }

}

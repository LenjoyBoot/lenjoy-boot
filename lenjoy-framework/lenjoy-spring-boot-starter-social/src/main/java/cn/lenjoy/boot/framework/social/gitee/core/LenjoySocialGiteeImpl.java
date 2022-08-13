package cn.lenjoy.boot.framework.social.gitee.core;

import cn.lenjoy.boot.framework.social.gitee.config.LenjoySocialGiteeProperties;

import static cn.lenjoy.boot.framework.social.gitee.constant.LenjoySocialGiteeConstant.*;

/**
 * @description: 乐享社区 Gitee 接口实现
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
public class LenjoySocialGiteeImpl implements LenjoySocialGitee {

    private final LenjoySocialGiteeProperties lenjoySocialGiteeProperties;

    public LenjoySocialGiteeImpl(LenjoySocialGiteeProperties lenjoySocialGiteeProperties) {
        this.lenjoySocialGiteeProperties = lenjoySocialGiteeProperties;
    }

    /**
     * 获取 gitee 三方应用登录 uri
     *
     * @return gitee 三方应用登录 uri
     */
    @Override
    public String giteeLoginUrl() {
        return String.format(LOGIN_URL, lenjoySocialGiteeProperties.getClientId(), lenjoySocialGiteeProperties.getRedirectUrl());
    }

    /**
     * 获取 gitee 三方应用token uri
     *
     * @param socialCode 授权码
     * @return gitee 三方应用token uri
     */
    @Override
    public String giteeTokenUrl(String socialCode) {
        return String.format(TOKEN_URL, socialCode, lenjoySocialGiteeProperties.getClientId(), lenjoySocialGiteeProperties.getRedirectUrl(), lenjoySocialGiteeProperties.getClientSecret());
    }

    /**
     * 获取 gitee 三方应用user uri
     *
     * @param accessToken 授权码
     * @return gitee 三方应用user uri
     */
    @Override
    public String giteeUserUrl(String accessToken) {
        return String.format(USER_URL, accessToken);

    }

}

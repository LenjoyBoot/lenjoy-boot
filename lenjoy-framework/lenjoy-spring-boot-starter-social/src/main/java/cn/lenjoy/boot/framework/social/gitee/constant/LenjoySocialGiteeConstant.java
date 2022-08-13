package cn.lenjoy.boot.framework.social.gitee.constant;

/**
 * @description: gitee　常量
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class LenjoySocialGiteeConstant {
    private LenjoySocialGiteeConstant() {}

    /**
     * https://gitee.com/oauth/authorize?client_id={client_id}&redirect_uri={redirect_uri}&response_type=code
     */
    public static final String LOGIN_URL = "https://gitee.com/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=code";
    /**
     * https://gitee.com/oauth/token?grant_type=authorization_code&code={code}&client_id={client_id}&redirect_uri={redirect_uri}&client_secret={client_secret}
     */
    public static final String TOKEN_URL = "https://gitee.com/oauth/token?grant_type=authorization_code&code=%s&client_id=%s&redirect_uri=%s&client_secret=%s";
    /**
     * https://gitee.com/api/v5/user?access_token={access_token}
     */
    public static final String USER_URL = "https://gitee.com/api/v5/user?access_token=%s";
}

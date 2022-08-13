package cn.lenjoy.boot.framework.social.gitee.core;

/**
 * @description: 乐享社区 Gitee 接口
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public interface LenjoySocialGitee {

    /**
     * 获取 gitee 三方应用login uri
     * @return gitee 三方应用login uri
     */
    String giteeLoginUrl();

    /**
     * 获取 gitee 三方应用token uri
     *
     * @param socialCode 授权码
     * @return gitee 三方应用token uri
     */
    String giteeTokenUrl(String socialCode);

    /**
     * 获取 gitee 三方应用user uri
     *
     * @param accessToken 授权码
     * @return gitee 三方应用user uri
     */
    String giteeUserUrl(String accessToken);

}

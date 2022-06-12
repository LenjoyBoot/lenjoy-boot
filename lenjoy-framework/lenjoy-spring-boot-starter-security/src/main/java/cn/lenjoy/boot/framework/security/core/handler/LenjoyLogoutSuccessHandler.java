package cn.lenjoy.boot.framework.security.core.handler;

import cn.lenjoy.boot.framework.common.util.json.JsonUtils;
import cn.lenjoy.boot.framework.common.util.result.ResultUtils;
import cn.lenjoy.boot.framework.common.util.servlet.ServletUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import cn.lenjoy.boot.framework.security.config.LenjoySecurityProperties;
import cn.lenjoy.boot.framework.security.core.authentication.LenjoyUserDetailsAuthenticationProvider;
import cn.lenjoy.boot.framework.security.util.LenjoySecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 用户注销处理器
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 12 星期日
 * @version: 1.0.0
 */
@Slf4j
public class LenjoyLogoutSuccessHandler implements LogoutSuccessHandler {

    private final LenjoySecurityProperties lenjoySecurityProperties;
    private final LenjoyUserDetailsAuthenticationProvider lenjoyUserDetailsAuthenticationProvider;

    public LenjoyLogoutSuccessHandler(LenjoySecurityProperties lenjoySecurityProperties, LenjoyUserDetailsAuthenticationProvider lenjoyUserDetailsAuthenticationProvider) {
        this.lenjoySecurityProperties = lenjoySecurityProperties;
        this.lenjoyUserDetailsAuthenticationProvider = lenjoyUserDetailsAuthenticationProvider;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // authentication 无用户信息
        // 获取用户信息，并注销用户
        String token = LenjoySecurityUtils.obtainAuthorization(request, lenjoySecurityProperties.getTokenHeader(), lenjoySecurityProperties.getTokenHeaderPrefix());
        if (StringUtils.isNotBlank(token)) {
            lenjoyUserDetailsAuthenticationProvider.logout(request, token);
        }
        log.info("用户[{}]，访问[{}]，注销成功", LenjoySecurityUtils.getUsername(), request.getRequestURI());
        // 返回状态码 200
        ServletUtils.writeJSON(response, JsonUtils.toJsonString(ResultUtils.ok("注销成功")));
    }
}

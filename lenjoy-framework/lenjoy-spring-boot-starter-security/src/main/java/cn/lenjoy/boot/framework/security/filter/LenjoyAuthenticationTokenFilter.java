package cn.lenjoy.boot.framework.security.filter;

import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import cn.lenjoy.boot.framework.security.config.LenjoySecurityProperties;
import cn.lenjoy.boot.framework.security.core.authentication.LenjoyUserDetailsAuthenticationProvider;
import cn.lenjoy.boot.framework.security.core.userdetails.LenjoyUserDetails;
import cn.lenjoy.boot.framework.security.util.LenjoySecurityUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: TokenAuthenticationTokenFilter 乐享 token 过滤器
 *
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 12 星期日
 * @version: 1.0.0
 */
public class LenjoyAuthenticationTokenFilter extends OncePerRequestFilter {

    private final LenjoySecurityProperties lenjoySecurityProperties;
    private final LenjoyUserDetailsAuthenticationProvider lenjoyUserDetailsAuthenticationProvider;

    public LenjoyAuthenticationTokenFilter(LenjoySecurityProperties lenjoySecurityProperties, LenjoyUserDetailsAuthenticationProvider lenjoyUserDetailsAuthenticationProvider) {
        this.lenjoySecurityProperties = lenjoySecurityProperties;
        this.lenjoyUserDetailsAuthenticationProvider = lenjoyUserDetailsAuthenticationProvider;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 验证 token 信息，将用户信息加入 Security 上下文
        String token = LenjoySecurityUtils.obtainAuthorization(request, lenjoySecurityProperties.getTokenHeader(), lenjoySecurityProperties.getTokenHeaderPrefix());
        if (StringUtils.isNotBlank(token)) {
            LenjoyUserDetails lenjoyUserDetails = lenjoyUserDetailsAuthenticationProvider.verifyTokenAndRefresh(request, token);
            if (lenjoyUserDetails != null) {
                LenjoySecurityUtils.setLenjoyUserDetails(lenjoyUserDetails, request);
            }
        }
        filterChain.doFilter(request, response);
    }
}

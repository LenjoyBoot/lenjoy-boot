package cn.lenjoy.boot.framework.security.util;

import cn.lenjoy.boot.framework.common.util.object.ObjectUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import cn.lenjoy.boot.framework.security.core.userdetails.LenjoyUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

import static cn.lenjoy.boot.framework.common.constant.CommonConstant.LENJOY;
import static cn.lenjoy.boot.framework.common.constant.CommonConstant.LENJOY_USER_DETAILS;

/**
 * @description: 乐享用户认证信息工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class LenjoySecurityUtils {

    private LenjoySecurityUtils() {}

    /**
     * 从 {@link HttpServletRequest} 中 Header 获取对应的 token
     *
     * @return token
     */
    public static String obtainAuthorization(HttpServletRequest request, String tokenHeader, String tokenHeaderPrefix) {
        if (ObjectUtils.isNull(request)) {
            return null;
        }
        String authorization = request.getHeader(tokenHeader);
        if (StringUtils.isBlank(authorization)) {
            return null;
        }
        if (!authorization.startsWith(tokenHeaderPrefix)) {
            return null;
        }
        return authorization.substring(7).trim();
    }

    /**
     * 获取当前认证信息
     *
     * @return 认证信息
     */
    public static Authentication getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return null;
        }
        return context.getAuthentication();
    }

    /**
     * 获取当前用户信息
     *
     * @return 当前用户信息
     */
    public static LenjoyUserDetails getLenjoyUserDetails() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getPrincipal() instanceof LenjoyUserDetails ? (LenjoyUserDetails) authentication.getPrincipal() : null;
    }

    /**
     * 获取当前用户名
     *
     * @return 当前用户名
     */
    public static String getUsername() {
        LenjoyUserDetails lenjoyUserDetails = getLenjoyUserDetails();
        return lenjoyUserDetails != null ? lenjoyUserDetails.getUsername() : null;
    }


    /**
     * 设置用户信息到 Security 上下文
     *
     * @param lenjoyUserDetails 用户信息
     */
    public static void setLenjoyUserDetails(LenjoyUserDetails lenjoyUserDetails, HttpServletRequest request) {
        // 设置用户信息到 Security 上下文
        SecurityContextHolder.getContext().setAuthentication(buildAuthentication(lenjoyUserDetails, request));
        // 设置用户信息到 web 容器中，可供请求调用链条直接使用，例如：过滤链，异常捕捉等
        request.setAttribute(LENJOY_USER_DETAILS, lenjoyUserDetails);
    }

    private static Authentication buildAuthentication(LenjoyUserDetails lenjoyUserDetails, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(lenjoyUserDetails, null, lenjoyUserDetails.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return authenticationToken;
    }
}

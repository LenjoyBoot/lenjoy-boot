package cn.lenjoy.boot.framework.security.core.handler;

import cn.lenjoy.boot.framework.common.util.object.ObjectUtils;
import cn.lenjoy.boot.framework.common.util.servlet.ServletUtils;
import cn.lenjoy.boot.framework.common.util.user.LenjoyUserThreadLocalHolder;
import cn.lenjoy.boot.framework.common.util.user.UserDTO;
import cn.lenjoy.boot.framework.security.core.userdetails.LenjoyUserDetails;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static cn.lenjoy.boot.framework.common.constant.CommonConstant.LENJOY_USER_DETAILS;

/**
 * @description: 乐享用户信息处理程序拦截器
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 16 星期四
 * @version: 1.0.0
 */
public class LenjoyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull Object handler) throws Exception {
        LenjoyUserDetails lenjoyUserDetails = (LenjoyUserDetails) ServletUtils.getAttribute(request, LENJOY_USER_DETAILS);
        if (ObjectUtils.isNotNull(lenjoyUserDetails)) {
            LenjoyUserThreadLocalHolder.set(new UserDTO(lenjoyUserDetails.getUsername(), lenjoyUserDetails.getUserType()));
        }
        return true;
    }

    @Override
    public void postHandle(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull Object handler, ModelAndView modelAndView) throws Exception {
        // 此处无后置处理业务
    }

    @Override
    public void afterCompletion(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull Object handler, Exception ex) throws Exception {
        LenjoyUserThreadLocalHolder.remove();
    }
}

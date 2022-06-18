package cn.lenjoy.boot.framework.security.core.handler;

import cn.lenjoy.boot.framework.common.util.object.ObjectUtils;
import cn.lenjoy.boot.framework.common.util.servlet.ServletUtils;
import cn.lenjoy.boot.framework.common.util.user.LenjoyUserThreadLocalHolder;
import cn.lenjoy.boot.framework.common.util.user.UserDTO;
import cn.lenjoy.boot.framework.security.core.userdetails.LenjoyUserDetails;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        LenjoyUserDetails lenjoyUserDetails = (LenjoyUserDetails) ServletUtils.getAttribute(request, LENJOY_USER_DETAILS);
        if (ObjectUtils.isNotNull(lenjoyUserDetails)) {
            LenjoyUserThreadLocalHolder.set(new UserDTO(lenjoyUserDetails.getUsername(), lenjoyUserDetails.getUserType()));
        }
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) {
        // 此处无后置处理业务
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) {
        LenjoyUserThreadLocalHolder.remove();
    }
}

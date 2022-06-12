package cn.lenjoy.boot.framework.security.core.handler;

import cn.lenjoy.boot.framework.common.util.json.JsonUtils;
import cn.lenjoy.boot.framework.common.util.result.ResultUtils;
import cn.lenjoy.boot.framework.common.util.servlet.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static cn.lenjoy.boot.framework.common.exception.ErrorCodeMsg.UNAUTHORIZED;

/**
 * @description: 认证失败处理类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@Slf4j
public class LenjoyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        log.debug("访问[{}]，未登录", request.getRequestURI(), authException);
        // 返回状态码 401
        ServletUtils.writeJSON(response, JsonUtils.toJsonString(ResultUtils.fail(UNAUTHORIZED)));
    }

}

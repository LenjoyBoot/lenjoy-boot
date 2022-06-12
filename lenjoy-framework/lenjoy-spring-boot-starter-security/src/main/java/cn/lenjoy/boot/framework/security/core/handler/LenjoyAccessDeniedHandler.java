package cn.lenjoy.boot.framework.security.core.handler;

import cn.lenjoy.boot.framework.common.util.json.JsonUtils;
import cn.lenjoy.boot.framework.common.util.result.ResultUtils;
import cn.lenjoy.boot.framework.common.util.servlet.ServletUtils;
import cn.lenjoy.boot.framework.security.util.LenjoySecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cn.lenjoy.boot.framework.common.exception.ErrorCodeMsg.FORBIDDEN;

/**
 * @description: 权限不足处理类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 12 星期日
 * @version: 1.0.0
 */
@Slf4j
public class LenjoyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info("用户[{}]，访问[{}]，权限不足", LenjoySecurityUtils.getUsername(), request.getRequestURI(), accessDeniedException);
        // 返回状态码 403
        ServletUtils.writeJSON(response, JsonUtils.toJsonString(ResultUtils.fail(FORBIDDEN)));
    }
}

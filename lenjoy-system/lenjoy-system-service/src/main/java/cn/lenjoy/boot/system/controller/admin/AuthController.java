package cn.lenjoy.boot.system.controller.admin;

import cn.lenjoy.boot.framework.common.base.response.BaseRes;
import cn.lenjoy.boot.framework.common.util.result.ResultUtils;
import cn.lenjoy.boot.system.service.auth.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;

/**
 * @description:
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 07 星期日
 * @version: 1.0.0
 */
@Api(tags = "管理后台 - 认证相关接口")
@RestController
@RequestMapping(value = "/system/auth")
@Validated
@Slf4j
public class AuthController {

    @Resource
    private AuthService authService;

    @PermitAll
    @GetMapping(value = "/login/{id}")
    @ApiOperation(value = "用户账号密码登录", produces = "application/json")
    public BaseRes<String> login(@PathVariable(value = "id") String id) {
        String test = authService.test();
        log.info("{}", test);
        return ResultUtils.ok(id);
    }

}

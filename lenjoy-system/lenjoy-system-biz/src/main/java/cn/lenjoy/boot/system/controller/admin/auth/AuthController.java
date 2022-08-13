package cn.lenjoy.boot.system.controller.admin.auth;

import cn.lenjoy.boot.framework.common.base.response.BaseRes;
import cn.lenjoy.boot.framework.common.util.json.JsonUtils;
import cn.lenjoy.boot.framework.social.gitee.core.LenjoySocialGitee;
import cn.lenjoy.boot.system.controller.admin.auth.vo.AuthLoginReqVO;
import cn.lenjoy.boot.system.controller.admin.auth.vo.AuthLoginResVO;
import cn.lenjoy.boot.system.service.auth.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import static cn.lenjoy.boot.framework.common.util.result.ResultUtils.ok;

/**
 * @description:
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 07 星期日
 * @version: 1.0.0
 */
@Api(tags = "管理后台-认证相关接口")
@RestController
@RequestMapping(value = "/system/auth")
@Validated
@Slf4j
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping(value = "/login")
    @PermitAll
    @ApiOperation(value = "用户名密码登录", produces = "application/json")
    public BaseRes<AuthLoginResVO> login(@RequestBody @Valid AuthLoginReqVO reqDTO) {
        log.info("用户名密码登录,入参: {}", JsonUtils.toJsonString(reqDTO)); // 封装日志注解进行
        return ok(authService.login(reqDTO));
    }

    @Resource
    private LenjoySocialGitee lenjoySocialGitee ;

    @GetMapping(value = "/test")
    @PermitAll
    @ApiOperation(value = "test", produces = "application/json")
    public BaseRes<String> test() {
        String s1 = lenjoySocialGitee.giteeLoginUrl();
        String s2= lenjoySocialGitee.giteeTokenUrl("");
        String s3 = lenjoySocialGitee.giteeUserUrl("7cb28172b41224d8d696644069ffe68e");
        return ok(s3);
    }



}

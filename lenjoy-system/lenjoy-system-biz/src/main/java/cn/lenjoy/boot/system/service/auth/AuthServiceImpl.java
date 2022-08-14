package cn.lenjoy.boot.system.service.auth;

import cn.lenjoy.boot.framework.web.restemplate.util.RestTemplateUtils;
import cn.lenjoy.boot.system.controller.admin.auth.vo.AuthLoginReqVO;
import cn.lenjoy.boot.system.controller.admin.auth.vo.AuthLoginResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 权限相关接口实现
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 07 星期日
 * @version: 1.0.0
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    /**
     * 用户名密码登录
     *
     * @param reqDTO 登录入参
     * @return 返回登录信息
     */
    @Override
    public AuthLoginResVO login(AuthLoginReqVO reqDTO) {
        return null;
    }

    @Resource
    private RestTemplateUtils restTemplateUtils;

    @Override
    public void test() {
        ResponseEntity<String> stringResponseEntity = restTemplateUtils.get("http://127.0.0.1:8080/system/auth/test", String.class);
        System.out.println(stringResponseEntity.getBody());
    }
}

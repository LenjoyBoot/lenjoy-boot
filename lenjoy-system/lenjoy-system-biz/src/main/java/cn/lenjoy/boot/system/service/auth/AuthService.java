package cn.lenjoy.boot.system.service.auth;

import cn.lenjoy.boot.system.controller.admin.auth.vo.AuthLoginReqVO;
import cn.lenjoy.boot.system.controller.admin.auth.vo.AuthLoginResVO;

/**
 * @description: 权限相关接口
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 07 星期日
 * @version: 1.0.0
 */
public interface AuthService {

    /**
     * 用户名密码登录
     * @param reqDTO 登录入参
     * @return 返回登录信息
     */
    AuthLoginResVO login(AuthLoginReqVO reqDTO);
}

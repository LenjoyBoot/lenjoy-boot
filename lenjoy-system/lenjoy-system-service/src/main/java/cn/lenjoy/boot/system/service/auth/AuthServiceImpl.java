package cn.lenjoy.boot.system.service.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description: 权限相关接口实现
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 07 星期日
 * @version: 1.0.0
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Override
    public String test() {
        return "null";
    }
}

package cn.lenjoy.boot.framework.social.core;

import cn.lenjoy.boot.framework.common.util.AssertUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 策略模式获取社区登录平台服务
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 14 星期日
 * @version: 1.0.0
 */
@Slf4j
public class LenjoySocialStrategy {

    /**
     * 策略模式，获取社交登录服务Map
     */
    private final Map<String, LenjoySocialService> serviceMap = new HashMap<>();

    public LenjoySocialStrategy(List<LenjoySocialService> services){
        log.info("social init: {}", services);
        for (LenjoySocialService service : services) {
            serviceMap.put(service.type(), service);
        }
    }

    /**
     * 验证是否三方登录成功
     * @param socialType 社交类型
     * @param socialCode 社交授权码
     * @return 是否验证成功
     */
    public boolean socialVerify(String socialType, String socialCode) {
        log.info("社交登录验证,平台: {}, 授权码: {}", socialType, socialType);
        LenjoySocialService lenjoySocialService = serviceMap.get(socialType);
        AssertUtils.notNull(lenjoySocialService, "不支持的社区平台授权登录");
        boolean result = lenjoySocialService.verify(socialCode);
        log.info("社交登录验证结果: {}", result);
        return result;
    }
}

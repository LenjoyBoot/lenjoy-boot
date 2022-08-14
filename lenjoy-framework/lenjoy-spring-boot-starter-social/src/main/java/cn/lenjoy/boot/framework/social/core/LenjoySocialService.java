package cn.lenjoy.boot.framework.social.core;

/**
 * @description: 乐享社区服务
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
public interface LenjoySocialService {

    /**
     * 社交类型
     * @return 社交类型
     */
    String type();

    /**
     * 社交验证
     * @param code 授权码
     * @return 是否验证成功
     */
    boolean verify(String code);
}

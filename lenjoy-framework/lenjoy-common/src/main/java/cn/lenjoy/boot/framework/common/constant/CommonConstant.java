package cn.lenjoy.boot.framework.common.constant;

/**
 * @description: 客户端通用枚举
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 12 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class CommonConstant {

    private CommonConstant() {}

    /**
     * 用户信息 键
     */
    public static final String LENJOY_USER_DETAILS = "lenjoyUserDetails";

    /**
     * 用户认证头 键
     */
    public static final String AUTHORIZATION = "Authorization";

    /**
     * 用户认证Lenjoy 键
     */
    public static final String LENJOY = "Lenjoy ";

    /**
     * 用户认证JWT 键
     */
    public static final String BEARER = "Bearer ";

    /**
     * 游客用户API前缀
     */
    public static final String PREFIX_API_TOURIST = "/tourist";

    /**
     * 会员用户API前缀
     */
    public static final String PREFIX_API_MEMBER = "/member";

    /**
     * 商户用户API前缀
     */
    public static final String PREFIX_API_BUSINESS = "/business";

    /**
     * 后台用户API前缀
     */
    public static final String PREFIX_API_ADMIN = "/admin";
}

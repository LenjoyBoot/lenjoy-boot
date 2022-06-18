package cn.lenjoy.boot.framework.common.util.user;

/**
 * @description: 全局用户信息工具
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 16 星期四
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class LenjoyUserThreadLocalHolder {

    private LenjoyUserThreadLocalHolder() {}

    /**
     * 用户上下文
     */
    private static final ThreadLocal<UserDTO> threadLocalHolder = new ThreadLocal<>();

    public static void set(UserDTO userDTO) {
        threadLocalHolder.set(userDTO);
    }

    public static UserDTO get() {
        return threadLocalHolder.get();
    }

    /**
     * 清空用户信息
     */
    public static void remove() {
        threadLocalHolder.remove();
    }

    /**
     * 获取用户类型
     * @return 当前登录用户类型
     */
    public static Integer getUserType() {
        return threadLocalHolder.get().getUserType();
    }

    /**
     * 获取用户名
     * @return 当前用户名
     */
    public static String getUsername() {
        return threadLocalHolder.get().getUsername();
    }

}

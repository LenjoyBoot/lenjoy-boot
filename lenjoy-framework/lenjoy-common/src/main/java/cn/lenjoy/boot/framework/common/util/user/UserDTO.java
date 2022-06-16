package cn.lenjoy.boot.framework.common.util.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description: 用户信息对象
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 16 星期四
 * @version: 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户类型
     */
    private Integer userType;

}

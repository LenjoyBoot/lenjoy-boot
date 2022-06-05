package cn.lenjoy.boot.test.dto;

import cn.lenjoy.boot.framework.common.enums.StatusEnum;
import cn.lenjoy.boot.framework.security.core.LenjoyUserDetails;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @description:
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class LenjoyMockUserDetails extends LenjoyUserDetails {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLogin;

    /**
     * 用户状态 0 可用 1 禁用
     * {@link StatusEnum}
     */
    private Integer status;

    /**
     * 用户部门
     */
    private String dept;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 租户编号
     */
    private Long tenantId;

    /**
     * 构造函数
     *
     * @param password 密码
     * @param username 用户名
     * @param authorities 权限列表
     */
    public LenjoyMockUserDetails(String password, String username, Set<GrantedAuthority> authorities) {
        super(password, username, authorities);
    }
}

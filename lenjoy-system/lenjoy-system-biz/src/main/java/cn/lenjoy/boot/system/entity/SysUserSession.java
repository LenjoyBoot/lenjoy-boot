package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户会话表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user_session")
public class SysUserSession extends BaseEntity {

    /**
     * 会话编号[32位UUID]
     */
    @TableField("session")
    private String session;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 用户类型(0 普通用户 1 管理员)
     */
    @TableField("user_type")
    private Integer userType;

    /**
     * 用户名称
     */
    @TableField("username")
    private String username;

    /**
     * 超时时间
     */
    @TableField("timeout")
    private LocalDateTime timeout;

    /**
     * 用户IP
     */
    @TableField("user_ip")
    private String userIp;

    /**
     * 用户代理
     */
    @TableField("user_agent")
    private String userAgent;


}

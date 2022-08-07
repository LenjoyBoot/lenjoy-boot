package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 登录日志表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_login_log")
public class SysLoginLog extends BaseEntity {

    /**
     * 日志类型
     */
    @TableField("log_type")
    private String logType;

    /**
     * 链路ID
     */
    @TableField("trace_id")
    private String traceId;

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
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 登录结果(0 成功 1 失败)
     */
    @TableField("result")
    private Integer result;

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

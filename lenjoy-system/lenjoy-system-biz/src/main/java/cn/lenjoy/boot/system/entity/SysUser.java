package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser extends BaseEntity {

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
     * 角色名称
     */
    @TableField("password")
    private String password;

    /**
     * 用户昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机号码
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 性别(0女 1男)
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 头像文件ID
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 加盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 注册时间
     */
    @TableField("register_time")
    private LocalDateTime registerTime;

    /**
     * 最后登录IP
     */
    @TableField("login_ip")
    private String loginIp;

    /**
     * 最后登录时间
     */
    @TableField("login_time")
    private LocalDateTime loginTime;

    /**
     * 登录次数
     */
    @TableField("login_count")
    private Integer loginCount;

    /**
     * 最后修改密码时间
     */
    @TableField("reset_password_time")
    private LocalDateTime resetPasswordTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 是否可用(0:可用;1:不可用
     */
    @TableField("enabled")
    private Integer enabled;


}

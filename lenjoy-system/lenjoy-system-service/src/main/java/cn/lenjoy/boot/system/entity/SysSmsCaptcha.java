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
 * 短信验证码表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_sms_captcha")
public class SysSmsCaptcha extends BaseEntity {

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 验证码
     */
    @TableField("code")
    private String code;

    /**
     * 用户IP
     */
    @TableField("user_ip")
    private String userIp;

    /**
     * 验证码类型(0 手机登录 1 修改手机号 2 修改密码 3 忘记密码 4 绑定手机号 )
     */
    @TableField("type")
    private Integer type;

    /**
     * 今天发送总数
     */
    @TableField("today_count")
    private Integer todayCount;

    /**
     * 是否使用(0:未使用 1:已使用)
     */
    @TableField("used")
    private Integer used;

    /**
     * 使用时间
     */
    @TableField("used_time")
    private LocalDateTime usedTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 是否可用(0:可用;1:不可用)
     */
    @TableField("enabled")
    private Integer enabled;


}

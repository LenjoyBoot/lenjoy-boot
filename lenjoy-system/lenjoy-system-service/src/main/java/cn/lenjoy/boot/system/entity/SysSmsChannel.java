package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 短信渠道表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_sms_channel")
public class SysSmsChannel extends BaseEntity {

    /**
     * 签名
     */
    @TableField("signature")
    private String signature;

    /**
     * 渠道代码
     */
    @TableField("code")
    private String code;

    /**
     * API 账号
     */
    @TableField("api_key")
    private String apiKey;

    /**
     * API秘钥
     */
    @TableField("api_secret")
    private String apiSecret;

    /**
     * 回调地址
     */
    @TableField("callback_path")
    private String callbackPath;

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

package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 短信模板表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_sms_template")
public class SysSmsTemplate extends BaseEntity {

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 类型(0 验证码 1 通知 2 营销)
     */
    @TableField("type")
    private Integer type;

    /**
     * 编码
     */
    @TableField("code")
    private String code;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 参数数组(['param'])
     */
    @TableField("params")
    private String params;

    /**
     * API模板ID
     */
    @TableField("api_template_id")
    private String apiTemplateId;

    /**
     * 渠道ID
     */
    @TableField("channel_id")
    private Long channelId;

    /**
     * 渠道编码
     */
    @TableField("channel_code")
    private String channelCode;

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

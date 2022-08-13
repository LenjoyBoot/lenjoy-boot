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
 * 短信日志表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_sms_log")
public class SysSmsLog extends BaseEntity {

    /**
     * 渠道ID
     */
    @TableField("channel_id")
    private Long channelId;

    /**
     * 渠道代码
     */
    @TableField("channel_code")
    private String channelCode;

    /**
     * 模板ID
     */
    @TableField("template_id")
    private Long templateId;

    /**
     * 模板代码
     */
    @TableField("template_code")
    private String templateCode;

    /**
     * 类型(0 验证码 1 通知 2 营销)
     */
    @TableField("template_type")
    private Integer templateType;

    /**
     * 模板内容
     */
    @TableField("template_content")
    private String templateContent;

    /**
     * 模板参数(["param"])
     */
    @TableField("template_params")
    private String templateParams;

    /**
     * API模板ID
     */
    @TableField("api_template_id")
    private String apiTemplateId;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

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
     * 发送状态(0 成功 1 失败)
     */
    @TableField("send_status")
    private Integer sendStatus;

    /**
     * 发送时间
     */
    @TableField("send_time")
    private LocalDateTime sendTime;

    /**
     * 发送结果代码
     */
    @TableField("send_code")
    private String sendCode;

    /**
     * 发送结果信息
     */
    @TableField("send_message")
    private String sendMessage;

    /**
     * API发送结果代码
     */
    @TableField("api_send_code")
    private String apiSendCode;

    /**
     * API发送结果信息
     */
    @TableField("api_send_message")
    private String apiSendMessage;

    /**
     * API发送序列号
     */
    @TableField("api_serial_no")
    private String apiSerialNo;

    /**
     * 链路ID
     */
    @TableField("trace_id")
    private String traceId;

    /**
     * 接收状态
     */
    @TableField("receive_status")
    private Integer receiveStatus;

    /**
     * 接收时间
     */
    @TableField("receive_time")
    private LocalDateTime receiveTime;

    /**
     * API接收结果代码
     */
    @TableField("api_receive_code")
    private String apiReceiveCode;

    /**
     * API接收结果信息
     */
    @TableField("api_receive_message")
    private String apiReceiveMessage;


}

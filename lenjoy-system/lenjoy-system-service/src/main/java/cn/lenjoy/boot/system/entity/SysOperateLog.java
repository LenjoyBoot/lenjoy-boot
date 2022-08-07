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
 * 系统操作日志表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_operate_log")
public class SysOperateLog extends BaseEntity {

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
     * 操作模块
     */
    @TableField("operate_module")
    private String operateModule;

    /**
     * 操作名称
     */
    @TableField("operate_name")
    private String operateName;

    /**
     * 操作类型
     */
    @TableField("operate_type")
    private String operateType;

    /**
     * 操作内容
     */
    @TableField("operate_content")
    private String operateContent;

    /**
     * 扩展字段
     */
    @TableField("extended_field")
    private String extendedField;

    /**
     * java方法名
     */
    @TableField("java_method")
    private String javaMethod;

    /**
     * java方法参数
     */
    @TableField("java_method_args")
    private String javaMethodArgs;

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

    /**
     * 请求方式
     */
    @TableField("request_method")
    private String requestMethod;

    /**
     * 请求地址
     */
    @TableField("request_url")
    private String requestUrl;

    /**
     * 请求参数
     */
    @TableField("request_params")
    private String requestParams;

    /**
     * 开始时间
     */
    @TableField("begin_time")
    private LocalDateTime beginTime;

    /**
     * 响应时间
     */
    @TableField("end_time")
    private LocalDateTime endTime;

    /**
     * 耗时
     */
    @TableField("duration")
    private Integer duration;

    /**
     * 响应结果代码
     */
    @TableField("result_code")
    private String resultCode;

    /**
     * 响应结果提示
     */
    @TableField("result_message")
    private String resultMessage;

    /**
     * 响应数据
     */
    @TableField("result_data")
    private String resultData;


}

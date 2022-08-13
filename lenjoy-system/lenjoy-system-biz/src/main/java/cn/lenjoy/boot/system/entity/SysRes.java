package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源权限表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_res")
public class SysRes extends BaseEntity {

    /**
     * 权限标识
     */
    @TableField("permission")
    private String permission;

    /**
     * 资源名称
     */
    @TableField("name")
    private String name;

    /**
     * 资源类型(0 页面 1 模块 2 元素 )
     */
    @TableField("type")
    private Integer type;

    /**
     * 资源路径
     */
    @TableField("path")
    private String path;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

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

    /**
     * 是否可见(0 可见 1 不可见)
     */
    @TableField("visible")
    private Integer visible;


}

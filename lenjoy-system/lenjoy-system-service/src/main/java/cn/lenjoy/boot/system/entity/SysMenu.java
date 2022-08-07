package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_menu")
public class SysMenu extends BaseEntity {

    /**
     * 权限标识
     */
    @TableField("permission")
    private String permission;

    /**
     * 父菜单ID
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 菜单名称
     */
    @TableField("name")
    private String name;

    /**
     * 菜单类型(0 菜单 1 按钮)
     */
    @TableField("type")
    private Integer type;

    /**
     * 路由路径
     */
    @TableField("path")
    private String path;

    /**
     * 组件路径
     */
    @TableField("component")
    private String component;

    /**
     * 资源图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 跳转路径
     */
    @TableField("redirect")
    private String redirect;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 是否缓存(0:开启 1:关闭)
     */
    @TableField("keep_alive")
    private Integer keepAlive;

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

package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作权限表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_permit")
public class SysPermit extends BaseEntity {

    /**
     * 权限标识
     */
    @TableField("permission")
    private String permission;

    /**
     * 权限名称
     */
    @TableField("name")
    private String name;

    /**
     * 权限类型(0 新增 1 删除 2 修改 3 查询)
     */
    @TableField("type")
    private Integer type;

    /**
     * 路径URL
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


}

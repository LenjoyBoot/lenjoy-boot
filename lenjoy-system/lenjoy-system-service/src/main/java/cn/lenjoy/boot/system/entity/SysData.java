package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据权限表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_data")
public class SysData extends BaseEntity {

    /**
     * 权限标识
     */
    @TableField("permission")
    private String permission;

    /**
     * 数据类型(0 数据库 1 数据表 2 数据列 3 数据行 )
     */
    @TableField("type")
    private Integer type;

    /**
     * 数据权限名称
     */
    @TableField("name")
    private String name;

    /**
     * 库名
     */
    @TableField("ds_name")
    private String dsName;

    /**
     * 表名
     */
    @TableField("table_name")
    private String tableName;

    /**
     * 数据列名(数组[column])
     */
    @TableField("column_filed")
    private String columnFiled;

    /**
     * 特定数据行ID(数组[id])
     */
    @TableField("row_id")
    private String rowId;

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

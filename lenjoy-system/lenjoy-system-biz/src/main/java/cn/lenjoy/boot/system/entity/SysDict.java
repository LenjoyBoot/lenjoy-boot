package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_dict")
public class SysDict extends BaseEntity {

    /**
     * 字典类型名称
     */
    @TableField("name")
    private String name;

    /**
     * 字典类型代码
     */
    @TableField("code")
    private String code;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 系统内置(0:否 1:是)
     */
    @TableField("built_in")
    private Integer builtIn;

    /**
     * 是否可用(0:可用;1:不可用
     */
    @TableField("enabled")
    private Integer enabled;


}

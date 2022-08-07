package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_dept")
public class SysDept extends BaseEntity {

    /**
     * 部门名称
     */
    @TableField("name")
    private String name;

    /**
     * 部门电话
     */
    @TableField("telephone")
    private String telephone;

    /**
     * 部门邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 部门地址
     */
    @TableField("address")
    private String address;

    /**
     * 父节点id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 显示顺序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 是否可用(0:可用;1:不可用
     */
    @TableField("enabled")
    private Integer enabled;


}

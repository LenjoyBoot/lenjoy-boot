package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门角色表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_dept_role")
public class SysDeptRole extends BaseEntity {

    /**
     * 部门ID
     */
    @TableField("dept_id")
    private Long deptId;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;


}

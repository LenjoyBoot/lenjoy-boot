package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色数据表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_role_data")
public class SysRoleData extends BaseEntity {

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;

    /**
     * 数据ID
     */
    @TableField("data_id")
    private Long dataId;


}

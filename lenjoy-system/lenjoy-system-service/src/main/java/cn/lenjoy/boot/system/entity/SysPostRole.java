package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 岗位角色表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_post_role")
public class SysPostRole extends BaseEntity {

    /**
     * 岗位ID
     */
    @TableField("post_id")
    private Long postId;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;


}

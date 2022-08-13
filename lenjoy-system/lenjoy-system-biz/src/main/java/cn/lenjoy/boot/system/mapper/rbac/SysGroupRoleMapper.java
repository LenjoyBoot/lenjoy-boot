package cn.lenjoy.boot.system.mapper.rbac;

import cn.lenjoy.boot.framework.mybatis.core.mapper.LenjoyBaseMapper;
import cn.lenjoy.boot.system.entity.SysGroupRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户组角色表 Mapper 接口
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Mapper
public interface SysGroupRoleMapper extends LenjoyBaseMapper<SysGroupRole> {

}

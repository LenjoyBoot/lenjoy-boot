package cn.lenjoy.boot.system.mapper.rbac;

import cn.lenjoy.boot.framework.mybatis.core.mapper.LenjoyBaseMapper;
import cn.lenjoy.boot.system.entity.SysUserSession;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户会话表 Mapper 接口
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Mapper
public interface SysUserSessionMapper extends LenjoyBaseMapper<SysUserSession> {

}

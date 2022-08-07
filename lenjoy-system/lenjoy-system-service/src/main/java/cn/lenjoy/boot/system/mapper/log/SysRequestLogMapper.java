package cn.lenjoy.boot.system.mapper.log;

import cn.lenjoy.boot.framework.mybatis.core.mapper.LenjoyBaseMapper;
import cn.lenjoy.boot.system.entity.SysRequestLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 请求日志表 Mapper 接口
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Mapper
public interface SysRequestLogMapper extends LenjoyBaseMapper<SysRequestLog> {

}

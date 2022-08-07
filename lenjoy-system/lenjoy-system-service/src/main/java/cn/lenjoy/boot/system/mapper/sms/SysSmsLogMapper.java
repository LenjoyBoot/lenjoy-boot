package cn.lenjoy.boot.system.mapper.sms;

import cn.lenjoy.boot.framework.mybatis.core.mapper.LenjoyBaseMapper;
import cn.lenjoy.boot.system.entity.SysSmsLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 短信日志表 Mapper 接口
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Mapper
public interface SysSmsLogMapper extends LenjoyBaseMapper<SysSmsLog> {

}

package cn.lenjoy.boot.system.mapper.notice;

import cn.lenjoy.boot.framework.mybatis.core.mapper.LenjoyBaseMapper;
import cn.lenjoy.boot.system.entity.SysNotice;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 公告表 Mapper 接口
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Mapper
public interface SysNoticeMapper extends LenjoyBaseMapper<SysNotice> {

}

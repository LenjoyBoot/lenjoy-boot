package cn.lenjoy.boot.system.mapper.sms;

import cn.lenjoy.boot.framework.mybatis.core.mapper.LenjoyBaseMapper;
import cn.lenjoy.boot.system.entity.SysSmsCaptcha;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 短信验证码表 Mapper 接口
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Mapper
public interface SysSmsCaptchaMapper extends LenjoyBaseMapper<SysSmsCaptcha> {

}

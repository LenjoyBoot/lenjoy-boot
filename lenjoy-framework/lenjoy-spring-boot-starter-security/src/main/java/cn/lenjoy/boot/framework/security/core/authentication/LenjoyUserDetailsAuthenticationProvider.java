package cn.lenjoy.boot.framework.security.core.authentication;

import cn.lenjoy.boot.framework.common.enums.UserTypeEnum;
import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.security.core.passwordencoder.LenjoyBCryptPasswordEncoder;
import cn.lenjoy.boot.framework.security.core.service.LenjoyUserDetailsService;
import cn.lenjoy.boot.framework.security.core.userdetails.LenjoyUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static cn.lenjoy.boot.framework.common.constant.CommonConstant.*;

/**
 * @description: 乐享用户认证处理策略
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 12 星期日
 * @version: 1.0.0
 */
@Slf4j
public class LenjoyUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final Map<UserTypeEnum, LenjoyUserDetailsService> services = new EnumMap<>(UserTypeEnum.class);
    private final LenjoyBCryptPasswordEncoder lenjoyBCryptPasswordEncoder;

    public LenjoyUserDetailsAuthenticationProvider(List<LenjoyUserDetailsService> lenjoyUserDetailsServiceList, LenjoyBCryptPasswordEncoder lenjoyBCryptPasswordEncoder) {
        // 从 spring 容器获取 bean, 并根据不同类型用户，放入多个不同用户类型的服务中
        lenjoyUserDetailsServiceList.forEach(service -> services.put(service.getUserType(), service));
        this.lenjoyBCryptPasswordEncoder = lenjoyBCryptPasswordEncoder;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // 额外的身份验证检查
        if (authentication.getCredentials() == null) {
            logger.debug("由于未提供凭据，因此无法进行身份验证");
            throw new BadCredentialsException("损坏的用户凭证信息");
        }
        // 验证密码信息
        String encodePassword = authentication.getCredentials().toString();
        if (lenjoyBCryptPasswordEncoder.matches(encodePassword, userDetails.getPassword())) {
            logger.debug("验证失败，因为密码与存储的值不匹配");
            throw new BadCredentialsException("损坏的用户凭证信息");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // 加载对应的用户处理服务，并返回用户信息对象
        return selectService(authentication).loadUserByUsername(username);
    }

    /**
     * 获取对应的用户服务 service
     * @param authentication UsernamePasswordAuthenticationToken 对象
     * @return 服务 service
     */
    private LenjoyUserDetailsService selectService(UsernamePasswordAuthenticationToken authentication) {
        UserTypeEnum userTypeEnum = getUserTypeEnum(authentication);
        LenjoyUserDetailsService service = services.get(userTypeEnum);
        AssertUtils.notNull(service, "对应的用户认证处理服务实现类未找到");
        return service;
    }

    /**
     * 获取用户类型 {@link UserTypeEnum}
     * @param authentication UsernamePasswordAuthenticationToken 对象
     * @return UserTypeEnum 用户类型
     */
    private UserTypeEnum getUserTypeEnum(UsernamePasswordAuthenticationToken authentication) {
        AssertUtils.isInstanceOf(LenjoyUsernamePasswordAuthenticationToken.class, authentication);
        LenjoyUsernamePasswordAuthenticationToken lenjoyUsernamePasswordAuthenticationToken = (LenjoyUsernamePasswordAuthenticationToken) authentication;
        UserTypeEnum userTypeEnum = lenjoyUsernamePasswordAuthenticationToken.getUserTypeEnum();
        AssertUtils.notNull(userTypeEnum, "用户类型,不能为空");
        return userTypeEnum;
    }

    //TokenAuthenticationTokenFilter 登录验证处理相关

    public LenjoyUserDetails verifyTokenAndRefresh(HttpServletRequest request, String token) {
        return selectService(request).verifyTokenAndRefresh(token);
    }

    private LenjoyUserDetailsService selectService(HttpServletRequest request) {
        UserTypeEnum userTypeEnum = getUserTypeEnum(request);
        LenjoyUserDetailsService service = services.get(userTypeEnum);
        AssertUtils.notNull(service, "对应的用户认证处理服务实现类未找到");
        return service;
    }

    /**
     * 根据API接口前缀获取用户类型
     * @param request HttpServletRequest 请求
     * @return 用户类型
     */
    private UserTypeEnum getUserTypeEnum(HttpServletRequest request) {
        // 根据 API URL 分组
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith(PREFIX_API_ADMIN)) {
            return UserTypeEnum.ADMIN;
        } else if (requestURI.startsWith(PREFIX_API_BUSINESS)) {
            return UserTypeEnum.MEMBER;
        } else if (requestURI.startsWith(PREFIX_API_MEMBER)) {
            return UserTypeEnum.MEMBER;
        } else if (requestURI.startsWith(PREFIX_API_TOURIST)) {
            return UserTypeEnum.TOURIST;
        }
        throw new IllegalArgumentException(String.format("URI[%s], 根据URL未匹配到对应的用户类型", requestURI));
    }

    /**
     * 通过 token 注销用户
     *
     * @param request 请求
     * @param token token
     */
    public void logout(HttpServletRequest request, String token) {
        selectService(request).logout(token);
    }
}

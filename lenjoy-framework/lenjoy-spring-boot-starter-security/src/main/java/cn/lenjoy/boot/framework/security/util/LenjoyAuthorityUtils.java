package cn.lenjoy.boot.framework.security.util;

import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: Authority 工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 11 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class LenjoyAuthorityUtils {

    private LenjoyAuthorityUtils() {}

    /**
     * 权限字符串转权限列表
     * String => Set<GrantedAuthority>
     *
     * @param authorityString 权限字符串,逗号分割
     * @return 权限列表
     */
    public static Set<GrantedAuthority> commaSeparatedStringToAuthoritySet(String authorityString) {
        return createAuthoritySet(StringUtils.stringToStringArray(authorityString, ","));
    }

    /**
     * 权限数组信息转换
     * String => Set<GrantedAuthority>
     *
     * @param authorities 权限列表
     * @return 权限列表 Set<GrantedAuthority>
     */
    public static Set<GrantedAuthority> createAuthoritySet(String... authorities) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>(authorities.length);
        for (String authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        return grantedAuthorities;
    }

    /**
     * 权限列表转换
     * Collection<? extends GrantedAuthority> => String
     *
     * @param userAuthorities 权限列表
     * @return 权限列表 Set<String>
     */
    public static Set<String> authoritySetToString(Collection<? extends GrantedAuthority> userAuthorities) {
        AssertUtils.notNull(userAuthorities, "权限列表,不可为空");
        Set<String> set = new HashSet<>(userAuthorities.size());
        for (GrantedAuthority authority : userAuthorities) {
            set.add(authority.getAuthority());
        }
        return set;
    }

}

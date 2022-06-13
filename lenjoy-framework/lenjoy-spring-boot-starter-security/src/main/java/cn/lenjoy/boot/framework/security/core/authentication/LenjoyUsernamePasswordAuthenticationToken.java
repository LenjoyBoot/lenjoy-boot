package cn.lenjoy.boot.framework.security.core.authentication;

import cn.lenjoy.boot.framework.common.enums.UserTypeEnum;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @description: 乐享 UsernamePasswordAuthenticationToken 实现类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 12 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class LenjoyUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private final transient UserTypeEnum userTypeEnum;

    public LenjoyUsernamePasswordAuthenticationToken(Object principal, Object credentials, UserTypeEnum userTypeEnum) {
        super(principal, credentials);
        this.userTypeEnum = userTypeEnum;
    }

    public LenjoyUsernamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, UserTypeEnum userTypeEnum) {
        super(principal, credentials, authorities);
        this.userTypeEnum = userTypeEnum;
    }

    public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

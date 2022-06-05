package cn.lenjoy.boot.framework.security.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

/**
 * @description: 认证用户信息
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
@Data
public class LenjoyUserDetails implements UserDetails {

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private final String username;

    /**
     * 权限列表
     */
    private final Set<GrantedAuthority> authorities;

    /**
     * 账号是否过期
     */
    private final boolean accountNonExpired;

    /**
     * 账号是否锁定
     */
    private final boolean accountNonLocked;

    /**
     * 密码是否过期
     */
    private final boolean credentialsNonExpired;

    /**
     * 是否可用
     */
    private final boolean enabled;

    /**
     * 构造函数 boolean 全部置为 true
     * 只关注 密码，用户名，权限列表
     *
     * @param password 密码
     * @param username 用户名
     * @param authorities 权限列表
     */
    public LenjoyUserDetails(String password, String username, Set<GrantedAuthority> authorities) {
        this(password, username, authorities, true, true, true, true);
    }

    /**
     * 构造函数
     *
     * @param password 密码
     * @param username 用户名
     * @param authorities 权限列表
     * @param accountNonExpired 账号是否未过期
     * @param accountNonLocked 账号是否未锁定
     * @param credentialsNonExpired 密码是否未过期
     * @param enabled 是否可用
     */
    public LenjoyUserDetails(String password, String username, Set<GrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.password = password;
        this.username = username;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return enabled;
    }
}

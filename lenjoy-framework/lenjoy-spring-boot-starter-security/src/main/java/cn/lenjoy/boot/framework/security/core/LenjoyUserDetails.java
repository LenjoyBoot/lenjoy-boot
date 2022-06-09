package cn.lenjoy.boot.framework.security.core;

import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.common.util.function.IFunction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
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
    private final Collection<? extends GrantedAuthority> authorities;

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
    public Collection<? extends GrantedAuthority> getAuthorities() {
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

    /**
     * 创建用户信息构造对象
     * @return 用户信息构造对象
     */
    public static LenjoyUserBuilder builder() {
        return new LenjoyUserBuilder();
    }

    /**
     * 创建用户信息构造对象
     * @param username 用户名
     * @return 用户信息构造对象
     */
    public static LenjoyUserBuilder withUsername(String username) {
        return builder().username(username);
    }

    /**
     * 创建用户信息构造对象
     * @param userDetails 用户信息
     * @return 用户信息构造对象
     */
    public static LenjoyUserBuilder withUserDetails(UserDetails userDetails) {
        return withUsername(userDetails.getUsername())
                .password(userDetails.getPassword())
                .authorities(userDetails.getAuthorities());
    }

    //TODO 密码策略


    /**
     * 用户信息构造对象
     */
    public static final class LenjoyUserBuilder {
        private String password;
        private String username;
        private Set<GrantedAuthority> authorities;
        private IFunction<String, String> passwordEncoder = pwd -> password;

        private LenjoyUserBuilder() {
        }

        public LenjoyUserBuilder password(String password) {
            AssertUtils.notNull(password, "密码,不可为空");
            this.password = password;
            return this;
        }

        public LenjoyUserBuilder username(String username) {
            AssertUtils.notNull(username, "用户名,不可为空");
            this.username = username;
            return this;
        }

        public LenjoyUserBuilder passwordEncoder(IFunction<String, String> passwordEncoder) {
            AssertUtils.notNull(passwordEncoder, "密码加密策略,不可为空");
            this.passwordEncoder = passwordEncoder;
            return this;
        }

        public LenjoyUserBuilder authorities(Collection<? extends GrantedAuthority> authorities) {
            this.authorities = new HashSet<>(authorities);
            return this;
        }

        public LenjoyUserBuilder authorities(String... authorities) {
            return authorities(createAuthorityList(authorities));
        }

        public static Set<GrantedAuthority> createAuthorityList(String... authorities) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>(authorities.length);
            for (String authority : authorities) {
                grantedAuthorities.add(new SimpleGrantedAuthority(authority));
            }
            return grantedAuthorities;
        }

        public LenjoyUserDetails build() {
            String encodedPassword = this.passwordEncoder.apply(this.password);
            return new LenjoyUserDetails(encodedPassword, username, authorities);
        }
    }
}

package cn.lenjoy.boot.framework.security.core.userdetails;

import cn.lenjoy.boot.framework.common.enums.StatusEnum;
import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.common.util.function.IFunction;
import cn.lenjoy.boot.framework.security.util.LenjoyAuthorityUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @description: 认证用户信息
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
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

    //******************************************************

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLogin;

    /**
     * 用户状态 0 可用 1 禁用
     * {@link StatusEnum}
     */
    private Integer status;

    /**
     * 用户部门
     */
    private String dept;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 租户编号
     */
    private Long tenantId;

    /**
     * 构造函数 boolean 全部置为 true
     * 只关注 密码，用户名，权限列表
     *
     * @param password 密码
     * @param username 用户名
     * @param authorities 权限列表
     */
    public LenjoyUserDetails(String password, String username, Collection<? extends GrantedAuthority>  authorities) {
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
    public LenjoyUserDetails(String password, String username, Collection<? extends GrantedAuthority>  authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.password = password;
        this.username = username;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LenjoyUserDetails) {
            return this.username.equals(((LenjoyUserDetails) obj).username);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getName() + " [" +
                "Username=" + this.username + ", " +
                "Password=[PROTECTED], " +
                "Enabled=" + this.enabled + ", " +
                "AccountNonExpired=" + this.accountNonExpired + ", " +
                "CredentialsNonExpired=" + this.credentialsNonExpired + ", " +
                "AccountNonLocked=" + this.accountNonLocked + ", " +
                "Granted Authorities=" + this.authorities + "]";
    }

    //LenjoyAuthorityComparator*****************************************

    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        AssertUtils.notNull(authorities, "无法传递空的 GrantedAuthority 集合");
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(new LenjoyUserDetails.LenjoyAuthorityComparator());
        for (GrantedAuthority grantedAuthority : authorities) {
            AssertUtils.notNull(grantedAuthority, "GrantedAuthority 列表不能包含任何空元素");
            sortedAuthorities.add(grantedAuthority);
        }
        return sortedAuthorities;
    }

    private static class LenjoyAuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
        @Override
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            if (g2.getAuthority() == null) {
                return -1;
            }
            if (g1.getAuthority() == null) {
                return 1;
            }
            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }

    //LenjoyUserBuilder*****************************************

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
     * @param lenjoyUserDetails 用户信息
     * @return 用户信息构造对象
     */
    public static LenjoyUserBuilder withUserDetails(LenjoyUserDetails lenjoyUserDetails) {
        return withUsername(lenjoyUserDetails.getUsername())
                .password(lenjoyUserDetails.getPassword())
                .authorities(lenjoyUserDetails.getAuthorities());
    }

    /**
     * 用户信息构造对象
     */
    public static final class LenjoyUserBuilder {
        private String password;
        private String username;
        private Collection<? extends GrantedAuthority> authorities;
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
            return authorities(LenjoyAuthorityUtils.createAuthoritySet(authorities));
        }

        public LenjoyUserDetails build() {
            String encodedPassword = this.passwordEncoder.apply(this.password);
            return new LenjoyUserDetails(encodedPassword, username, authorities);
        }
    }
}

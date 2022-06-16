package cn.lenjoy.boot.framework.security.config;

import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import cn.lenjoy.boot.framework.security.core.authentication.LenjoyUserDetailsAuthenticationProvider;
import cn.lenjoy.boot.framework.security.core.handler.LenjoyAccessDeniedHandler;
import cn.lenjoy.boot.framework.security.core.handler.LenjoyAuthenticationEntryPoint;
import cn.lenjoy.boot.framework.security.core.handler.LenjoyLogoutSuccessHandler;
import cn.lenjoy.boot.framework.security.core.filter.LenjoyAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

import static cn.lenjoy.boot.framework.common.constant.CommonConstant.*;

/**
 * @description: 乐享 defaultSecurityFilterChain
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 13 星期一
 * @version: 1.0.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class LenjoyDefaultSecurityFilterChain {

    @Resource
    private LenjoyUserDetailsAuthenticationProvider lenjoyUserDetailsAuthenticationProvider;

    @Resource
    private LenjoyAccessDeniedHandler lenjoyAccessDeniedHandler;

    @Resource
    private LenjoyLogoutSuccessHandler lenjoyLogoutSuccessHandler;

    @Resource
    private LenjoyAuthenticationEntryPoint lenjoyAuthenticationEntryPoint;

    @Resource
    private LenjoyAuthenticationTokenFilter lenjoyAuthenticationTokenFilter;

    /**
     * 默认 SecurityFilterChain 安全过滤链
     */
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // 基于 token 无需csrf
        http.csrf().disable();
        // 不允许 frame 防止站点劫持
        http.headers().frameOptions().disable();
        // 基于 token 无需session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 静态资源,可匿名访问
        // swagger静态资源,可匿名访问,由knight4j进行文档权限认证
        http.authorizeHttpRequests().antMatchers(
                HttpMethod.GET,
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/webjars/**",
                "/swagger-resources/**",
                "/swagger-ui/**",
                "/v3/api-docs/**"
        ).permitAll();
        // 跨域请求
        http.authorizeHttpRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
        // 接口白名单
        http.authorizeHttpRequests().antMatchers(PREFIX_API_MEMBER + PREFIX_API_AUTH).permitAll();
        http.authorizeHttpRequests().antMatchers(PREFIX_API_BUSINESS + PREFIX_API_AUTH).permitAll();
        http.authorizeHttpRequests().antMatchers(PREFIX_API_ADMIN + PREFIX_API_AUTH).permitAll();
        // 其余请求 需授权访问
        http.authorizeHttpRequests().anyRequest().authenticated();
        // Token 过滤器
        http.addFilterBefore(lenjoyAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // 自定义权限不足处理
        http.exceptionHandling().accessDeniedHandler(lenjoyAccessDeniedHandler);
        // 自定义认证失败处理
        http.exceptionHandling().authenticationEntryPoint(lenjoyAuthenticationEntryPoint);
        // 自定义用注销处理
        http.logout().logoutSuccessHandler(lenjoyLogoutSuccessHandler).logoutRequestMatcher(request ->
                StringUtils.isEquals(request.getRequestURI(), PREFIX_API_MEMBER + PREFIX_API_LOGOUT)
                || StringUtils.isEquals(request.getRequestURI(), PREFIX_API_BUSINESS + PREFIX_API_LOGOUT)
                || StringUtils.isEquals(request.getRequestURI(), PREFIX_API_ADMIN + PREFIX_API_LOGOUT)
        );
        // 自定义认证处理
        http.authenticationProvider(lenjoyUserDetailsAuthenticationProvider);
        return http.build();
    }
}

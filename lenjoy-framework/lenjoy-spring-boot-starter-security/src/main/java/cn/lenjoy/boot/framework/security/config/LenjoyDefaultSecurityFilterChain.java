package cn.lenjoy.boot.framework.security.config;

import cn.lenjoy.boot.framework.common.util.object.ObjectUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import cn.lenjoy.boot.framework.security.core.authentication.LenjoyUserDetailsAuthenticationProvider;
import cn.lenjoy.boot.framework.security.core.filter.LenjoyAuthenticationTokenFilter;
import cn.lenjoy.boot.framework.security.core.handler.LenjoyAccessDeniedHandler;
import cn.lenjoy.boot.framework.security.core.handler.LenjoyAuthenticationEntryPoint;
import cn.lenjoy.boot.framework.security.core.handler.LenjoyLogoutSuccessHandler;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import java.util.Map;
import java.util.Set;

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
@Slf4j
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

    @Resource
    private ApplicationContext applicationContext;

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


        // 跨域请求
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
        // 接口白名单
        http.authorizeRequests().antMatchers(PREFIX_API_MEMBER + PREFIX_API_AUTH).permitAll();
        http.authorizeRequests().antMatchers(PREFIX_API_BUSINESS + PREFIX_API_AUTH).permitAll();
        http.authorizeRequests().antMatchers(PREFIX_API_ADMIN + PREFIX_API_AUTH).permitAll();
        // 过滤无需认证请求
        Multimap<HttpMethod, String> permitAllUrls = getPermitAllUrl();
        http.authorizeRequests()
                // String[] y = x.toArray(new String[0]); 已知 返回String数组则使用new String[0]，只用于创建对象，不存在任何内容
                .antMatchers(HttpMethod.GET, permitAllUrls.get(HttpMethod.GET).toArray(new String[0])).permitAll()
                .antMatchers(HttpMethod.POST, permitAllUrls.get(HttpMethod.POST).toArray(new String[0])).permitAll()
                .antMatchers(HttpMethod.PUT, permitAllUrls.get(HttpMethod.PUT).toArray(new String[0])).permitAll()
                .antMatchers(HttpMethod.DELETE, permitAllUrls.get(HttpMethod.DELETE).toArray(new String[0])).permitAll();
        // 静态资源,可匿名访问
        // swagger静态资源,可匿名访问,由knight4j进行文档权限认证
        http.authorizeRequests()
                .antMatchers(
                    HttpMethod.GET,
                    "/favicon.ico",
                    "/**/*.html",
                    "/**/*.css",
                    "/**/*.js",
                    "/webjars/**",
                    "/swagger-resources/**",
                    "/swagger-ui/**",
                    "/v3/api-docs/**"
                )
                .permitAll();
        // 其余请求 需授权访问
        http.authorizeRequests().anyRequest().authenticated();
        // 自定义认证处理
        http.authenticationProvider(lenjoyUserDetailsAuthenticationProvider);
        return http.build();
    }

    /**
     * 无需认证的URL列表
     */
    private Multimap<HttpMethod, String> getPermitAllUrl() {
        Multimap<HttpMethod, String> result = HashMultimap.create();
        // 上下文中获取 RequestMappingHandlerMapping
        RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) applicationContext.getBean("requestMappingHandlerMapping");
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
        // 获得有 @PermitAll 注解的接口
        handlerMethodMap.forEach((key, value) -> {
            if (value.hasMethodAnnotation(PermitAll.class) && key.getPatternsCondition() != null) {
                Set<String> urls = key.getPatternsCondition().getPatterns();
                key.getMethodsCondition().getMethods().forEach(requestMethod -> {
                    if (ObjectUtils.equals(requestMethod, RequestMethod.GET)) {
                        result.putAll(HttpMethod.GET, urls);
                    } else if (ObjectUtils.equals(requestMethod, RequestMethod.POST)) {
                        result.putAll(HttpMethod.POST, urls);
                    } else if (ObjectUtils.equals(requestMethod, RequestMethod.PUT)) {
                        result.putAll(HttpMethod.PUT, urls);
                    } else if (ObjectUtils.equals(requestMethod, RequestMethod.DELETE)) {
                        result.putAll(HttpMethod.DELETE, urls);
                    }
                });
            }
        });
        return result;
    }
}

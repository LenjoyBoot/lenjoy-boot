package cn.lenjoy.boot.framework.security.config;

import cn.lenjoy.boot.framework.security.core.authentication.LenjoyUserDetailsAuthenticationProvider;
import cn.lenjoy.boot.framework.security.core.context.LenjoySecurityContextHolderStrategy;
import cn.lenjoy.boot.framework.security.core.filter.LenjoyAuthenticationTokenFilter;
import cn.lenjoy.boot.framework.security.core.handler.LenjoyAccessDeniedHandler;
import cn.lenjoy.boot.framework.security.core.handler.LenjoyAuthenticationEntryPoint;
import cn.lenjoy.boot.framework.security.core.handler.LenjoyHandlerInterceptor;
import cn.lenjoy.boot.framework.security.core.handler.LenjoyLogoutSuccessHandler;
import cn.lenjoy.boot.framework.security.core.passwordencoder.LenjoyBCryptPasswordEncoder;
import cn.lenjoy.boot.framework.security.core.service.LenjoyUserDetailsService;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @description: 乐享 Spring Security 自动配置类
 * "@Configuration(proxyBeanMethods = true) 默认" 注入到容器中的bean实例之间有依赖关系时，建议使用Full全模式
 * "@Configuration(proxyBeanMethods = false)" 注入到容器中的bean实例之间没有依赖关系时，建议使用Lite轻量级模式，以提高springboot的启动速度和性能
 *
 * "@EnableWebSecurity" 添加 Security 过滤器
 * "@EnableGlobalMethodSecurity(prePostEnabled = true)" 开启方法级别过滤
 *
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(LenjoySecurityProperties.class)
@ConditionalOnProperty(prefix = "lenjoy.security", value = "enable", matchIfMissing = true)
public class LenjoySecurityAutoConfiguration {

    private final LenjoySecurityProperties lenjoySecurityProperties;

    public LenjoySecurityAutoConfiguration(LenjoySecurityProperties lenjoySecurityProperties) {
        this.lenjoySecurityProperties = lenjoySecurityProperties;
    }

    /**
     * 认证失败处理 Bean
     */
    @Bean
    public LenjoyAuthenticationEntryPoint lenjoyAuthenticationEntryPoint() {
        return new LenjoyAuthenticationEntryPoint();
    }

    /**
     * 权限不足处理 Bean
     */
    @Bean
    public LenjoyAccessDeniedHandler lenjoyAccessDeniedHandler() {
        return new LenjoyAccessDeniedHandler();
    }

    /**
     * 密码加解策略
     */
    @Bean
    public LenjoyBCryptPasswordEncoder lenjoyBCryptPasswordEncoder() {
        return new LenjoyBCryptPasswordEncoder();
    }

    /**
     * 身份验证处理 Bean
     */
    @Bean
    public LenjoyUserDetailsAuthenticationProvider lenjoyUserDetailsAuthenticationProvider(List<LenjoyUserDetailsService> lenjoyUserDetailsServiceList, PasswordEncoder passwordEncoder) {
        return new LenjoyUserDetailsAuthenticationProvider(lenjoyUserDetailsServiceList, passwordEncoder);
    }

    /**
     * 用户注销处理 Bean
     */
    @Bean
    public LenjoyLogoutSuccessHandler lenjoyLogoutSuccessHandler(LenjoyUserDetailsAuthenticationProvider lenjoyUserDetailsAuthenticationProvider) {
        return new LenjoyLogoutSuccessHandler(lenjoySecurityProperties, lenjoyUserDetailsAuthenticationProvider);
    }

    /**
     * Security 的上下文策略 Bean
     * 通过 MethodInvokingFactoryBean(FactoryBean) 将 LenjoySecurityContextHolderStrategy 策略配置到 SecurityContextHolder
     */
    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean() {
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setTargetClass(SecurityContextHolder.class);
        methodInvokingFactoryBean.setTargetMethod("setStrategyName");
        methodInvokingFactoryBean.setArguments(LenjoySecurityContextHolderStrategy.class.getName());
        return methodInvokingFactoryBean;
    }

    /**
     * Token 身份验证处理 bean
     */
    @Bean
    public LenjoyAuthenticationTokenFilter lenjoyAuthenticationTokenFilter(LenjoyUserDetailsAuthenticationProvider lenjoyUserDetailsAuthenticationProvider) {
        return new LenjoyAuthenticationTokenFilter(lenjoySecurityProperties, lenjoyUserDetailsAuthenticationProvider);
    }

    @Bean
    public LenjoyHandlerInterceptor lenjoyHandlerInterceptor() {
        return new LenjoyHandlerInterceptor();
    }
}

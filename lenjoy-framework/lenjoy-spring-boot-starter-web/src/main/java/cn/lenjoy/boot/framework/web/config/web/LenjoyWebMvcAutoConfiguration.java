package cn.lenjoy.boot.framework.web.config.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description: 乐享 Web 配置
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 04 星期六
 * @version: 1.0.0
 */
@Configuration
public class LenjoyWebMvcAutoConfiguration extends WebMvcConfigurationSupport {

    /**
     * 允许静态文件访问注册
     * @param registry 资源处理程序注册表
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/doc.html");
        super.addResourceHandlers(registry);
    }

    /**
     * 解决跨域问题
     * @return CorsFilter Bean
     */
    @Bean
    @ConditionalOnMissingBean
    public CorsFilter corsFilterBean() {
        CorsConfiguration config = new CorsConfiguration();
        //允许域名跨域
        config.addAllowedOrigin("*");
        //允许cookie
        config.setAllowCredentials(true);
        //允许原始头信息
        config.addAllowedHeader("*");
        //允许请求方法跨域
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 配置过滤路径
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}

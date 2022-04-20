package cn.lenjoy.boot.framework.web.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @description: 乐享 Web 配置
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 20 星期三
 * @version: 1.0.0
 */
public class LenjoyWebAutoConfiguration {

    @Bean
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

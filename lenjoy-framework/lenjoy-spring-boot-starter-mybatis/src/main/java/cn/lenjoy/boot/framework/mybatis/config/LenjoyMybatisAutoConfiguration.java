package cn.lenjoy.boot.framework.mybatis.config;

import cn.lenjoy.boot.framework.mybatis.core.handler.LenjoyMetaObjectHandler;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 乐享 Mybatis 配置
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 16 星期四
 * @version: 1.0.0
 */
@Configuration
@MapperScan(value = "${lenjoy.mybatis.basePackage}", annotationClass = Mapper.class)
@EnableConfigurationProperties(LenjoyMybatisProperties.class)
@ConditionalOnProperty(prefix = "lenjoy.mybatis", value = "enable", matchIfMissing = true)
public class LenjoyMybatisAutoConfiguration {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

    @Bean
    public MetaObjectHandler defaultMetaObjectHandler() {
        return new LenjoyMetaObjectHandler();
    }
}

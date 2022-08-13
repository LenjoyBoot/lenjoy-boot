package cn.lenjoy.boot.framework.web.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

/**
 * @description: 乐享 swagger 自动装配
 * 使用 knife4j 增加功能，OpenApiExtensionResolver 无法自动注入。
 * 错误提示：Could not autowire. No beans of "OpenApiExtensionResolver" type found
 * 解决方案：@EnableKnife4j
 *
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 20 星期三
 * @version: 1.0.0
 */
@EnableKnife4j
@Configuration
@ConditionalOnClass({Docket.class, ApiInfoBuilder.class})
@EnableConfigurationProperties(LenjoySwaggerProperties.class)
@ConditionalOnProperty(prefix = "lenjoy.swagger", value = "enable", matchIfMissing = true)
public class LenjoySwaggerAutoConfiguration {

    private final LenjoySwaggerProperties lenjoySwaggerProperties;
    private final OpenApiExtensionResolver openApiExtensionResolver;

    public LenjoySwaggerAutoConfiguration(LenjoySwaggerProperties lenjoySwaggerProperties, OpenApiExtensionResolver openApiExtensionResolver) {
        this.lenjoySwaggerProperties = lenjoySwaggerProperties;
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 配置扫描路径
                .apis(basePackage(lenjoySwaggerProperties.getBasePackage()))
                .paths(PathSelectors.any())
                // 扫描所有有注解的api
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build()
                // knife4j 增强
                .extensions(openApiExtensionResolver.buildExtensions(lenjoySwaggerProperties.getVersion()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title(lenjoySwaggerProperties.getTitle())
                // 描述
                .description(lenjoySwaggerProperties.getDescription())
                // 信息
                .contact(new Contact(lenjoySwaggerProperties.getAuthor(), lenjoySwaggerProperties.getUrl(), lenjoySwaggerProperties.getEmail()))
                // 版本号
                .version(lenjoySwaggerProperties.getVersion())
                .build();
    }

}

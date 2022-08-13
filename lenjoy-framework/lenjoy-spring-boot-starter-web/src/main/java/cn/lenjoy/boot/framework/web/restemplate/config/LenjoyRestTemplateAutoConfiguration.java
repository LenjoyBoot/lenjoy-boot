package cn.lenjoy.boot.framework.web.restemplate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 乐享 RestTemplate 自动配置类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(LenjoyRestTemplateProperties.class)
@ConditionalOnProperty(prefix = "lenjoy.restemplate", value = "enable", matchIfMissing = true)
public class LenjoyRestTemplateAutoConfiguration {

    private final LenjoyRestTemplateProperties lenjoyRestTemplateProperties;

    public LenjoyRestTemplateAutoConfiguration(LenjoyRestTemplateProperties lenjoyRestTemplateProperties) {
        this.lenjoyRestTemplateProperties = lenjoyRestTemplateProperties;
    }

    @Bean
    @ConditionalOnMissingBean(name = "restTemplate")
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        return new RestTemplate(clientHttpRequestFactory);
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(lenjoyRestTemplateProperties.getConnectTimeout());
        simpleClientHttpRequestFactory.setReadTimeout(lenjoyRestTemplateProperties.getReadTimeout());
        return simpleClientHttpRequestFactory;
    }

}

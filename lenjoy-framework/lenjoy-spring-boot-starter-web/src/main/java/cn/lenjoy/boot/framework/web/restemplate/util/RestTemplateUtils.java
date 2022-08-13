package cn.lenjoy.boot.framework.web.restemplate.util;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @description: RestTemplate 工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
@Component
public class RestTemplateUtils {
    private RestTemplateUtils() {}

    private RestTemplate restTemplate;

    public RestTemplateUtils(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



}

package cn.lenjoy.boot.framework.web.restemplate.util;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @description: RestTemplate 工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
@Component
@Slf4j
public class RestTemplateUtils {

    private final RestTemplate restTemplate;

    public RestTemplateUtils(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // ==================== GET ====================

    /**
     * GET请求,无参
     * 返回 String
     *
     * @param url 请求URL
     * @return Body 响应 String
     */
    public String getString(String url) {
        return get(url, String.class).getBody();
    }

    /**
     * GET请求,无参
     * 返回 Object
     *
     * @param url 请求URL
     * @param responseType 返回对象类型
     * @return ResponseEntity 响应对象封装类
     */
    public <T> ResponseEntity<T> get(String url, Class<T> responseType) {
        log.info("GET Request Url: {}, Result Class: {}", url, responseType);
        ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, responseType);
        log.info("GET Response Entity: {}", JSON.toJSONString(responseEntity));
        return responseEntity;
    }

    /**
     * GET请求,Object1,Object2,...
     * 返回 Object
     *
     * @param url 请求URL
     * @param responseType 返回对象类型
     * @param uriVariables URL中的变量，按顺序依次对应
     * @return ResponseEntity 响应对象封装类
     */
    public <T> ResponseEntity<T> get(String url, Class<T> responseType, Object... uriVariables) {
        log.info("GET Request Url: {}, Result Class: {}, uriVariables: {}", url, responseType, uriVariables);
        ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, responseType, uriVariables);
        log.info("GET Response Entity: {}", JSON.toJSONString(responseEntity));
        return responseEntity;
    }

    /**
     * GET请求,Map<key, value>
     * 返回 Object
     *
     * @param url 请求URL
     * @param responseType 返回对象类型
     * @param uriVariables URL中的变量，与Map中的key对应
     * @return ResponseEntity 响应对象封装类
     */
    public <T> ResponseEntity<T> get(String url, Class<T> responseType, Map<String, ?> uriVariables) {
        log.info("GET Request Url: {}, Result Class: {}, uriVariables: {}", url, responseType, uriVariables);
        ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, responseType, uriVariables);
        log.info("GET Response Entity: {}", JSON.toJSONString(responseEntity));
        return responseEntity;
    }

    /**
     * 带请求头的GET请求调用方式
     *
     * @param url 请求URL
     * @param headers 请求头参数
     * @param responseType 返回对象类型
     * @param uriVariables URL中的变量，按顺序依次对应
     * @return ResponseEntity 响应对象封装类
     */
    public <T> ResponseEntity<T> get(String url, Map<String, String> headers, Class<T> responseType, Object... uriVariables) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(headers);
        return get(url, httpHeaders, responseType, uriVariables);
    }

    /**
     * 带请求头的GET请求调用方式
     *
     * @param url 请求URL
     * @param headers 请求头参数
     * @param responseType 返回对象类型
     * @param uriVariables URL中的变量，按顺序依次对应
     * @return ResponseEntity 响应对象封装类
     */
    public <T> ResponseEntity<T> get(String url, HttpHeaders headers, Class<T> responseType, Object... uriVariables) {
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        return exchange(url, HttpMethod.GET, requestEntity, responseType, uriVariables);
    }

    /**
     * 带请求头的GET请求调用方式
     *
     * @param url 请求URL
     * @param headers 请求头参数
     * @param responseType 返回对象类型
     * @param uriVariables URL中的变量，与Map中的key对应
     * @return ResponseEntity 响应对象封装类
     */
    public <T> ResponseEntity<T> get(String url, Map<String, String> headers, Class<T> responseType, Map<String, ?> uriVariables) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(headers);
        return get(url, httpHeaders, responseType, uriVariables);
    }

    /**
     * 带请求头的GET请求调用方式
     *
     * @param url 请求URL
     * @param headers 请求头参数
     * @param responseType 返回对象类型
     * @param uriVariables URL中的变量，与Map中的key对应
     * @return ResponseEntity 响应对象封装类
     */
    public <T> ResponseEntity<T> get(String url, HttpHeaders headers, Class<T> responseType, Map<String, ?> uriVariables) {
        return exchange(url, HttpMethod.GET, new HttpEntity<>(headers), responseType, uriVariables);
    }

    // ==================== 通用方法 ====================

    /**
     * 通用调用方式
     *
     * @param url 请求URL
     * @param method 请求方法类型
     * @param requestEntity 请求头和请求体封装对象
     * @param responseType 返回对象类型
     * @param uriVariables URL中的变量，按顺序依次对应
     * @return ResponseEntity 响应对象封装类
     */
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) {
        log.info("GET Request Url: {}, HttpMethod: {}, requestEntity: {}, Result Class: {}, uriVariables: {}", url, method, requestEntity, responseType, uriVariables);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
        log.info("GET Response Entity: {}", JSON.toJSONString(responseEntity));
        return responseEntity;
    }

    /**
     * 通用调用方式
     *
     * @param url 请求URL
     * @param method 请求方法类型
     * @param requestEntity 请求头和请求体封装对象
     * @param responseType 返回对象类型
     * @param uriVariables URL中的变量，与Map中的key对应
     * @return ResponseEntity 响应对象封装类
     */
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Map<String, ?> uriVariables) {
        log.info("GET Request Url: {}, HttpMethod: {}, requestEntity: {}, Result Class: {}, uriVariables: {}", url, method, requestEntity, responseType, uriVariables);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
        log.info("GET Response Entity: {}", JSON.toJSONString(responseEntity));
        return responseEntity;
    }

    public String postString(String tokenUrl) {
        return null;
    }
}

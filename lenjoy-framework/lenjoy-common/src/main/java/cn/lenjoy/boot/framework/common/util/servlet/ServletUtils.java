package cn.lenjoy.boot.framework.common.util.servlet;

import cn.lenjoy.boot.framework.common.util.json.JsonUtils;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.net.URLEncoder;

/**
 * @description: 客户端工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class ServletUtils {

    private ServletUtils() {}

    /**
     * 客户端输出 JSON 字符串
     *
     * @param response 响应
     * @param object 对象，序列化对象
     */
    public static void writeJSON(HttpServletResponse response, Object object) {
        String content = JsonUtils.toJsonString(object);
        write(response, content, MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     * 客户端输出 附件
     *
     * @param response 响应
     * @param filename 文件名
     * @param content 二进制内容
     */
    @SneakyThrows
    public static void writeAttachment(HttpServletResponse response, String filename, byte[] content) {
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8").replace("+", "%20"));
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        try(ServletOutputStream outputStream = response.getOutputStream()) {
            outputStream.write(content);
        }
    }

    /**
     * 客户端输出数据
     *
     * @param response 响应
     * @param text 响应文本
     * @param contentType 文本类型
     */
    @SneakyThrows
    public static void write(HttpServletResponse response, String text, String contentType) {
        response.setContentType(contentType);
        try(Writer writer = response.getWriter()) {
            writer.write(text);
            writer.flush();
        }
    }

    /**
     * 获取请求 UA 信息
     *
     * @return 请求 ua 信息
     */
    public static String getUserAgent() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        String ua = request.getHeader("User-Agent");
        return ua != null ? ua : "";
    }

    /**
     * 获取用户请求 IP 地址
     *
     * @return 返回 IP 地址
     */
    public static String getClientIP() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        return getClientIP(request);
    }

    /**
     * 获取用户请求 IP 地址
     *
     * @param request 请求
     * @return 返回 IP 地址
     */
    public static String getClientIP(HttpServletRequest request) {
        String[] headers = { "X-Forwarded-For", "X-Real-IP", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR", "WL-Proxy-Client-IP", "X-Real-IP" };
        String ip;
        for (String header : headers) {
            ip = request.getHeader(header);
            if (isNotUnknown(ip)) {
                return getMultistageReverseProxyIp(ip);
            }
        }
        ip = request.getRemoteAddr();
        return getMultistageReverseProxyIp(ip);
    }

    /**
     * 获取多级反向代理 IP 地址
     * 返回第一个有效 IP 地址
     *
     * @param ip 多级代理 IP 字符串
     * @return 返回 IP 地址
     */
    private static String getMultistageReverseProxyIp(String ip) {
        if (ip != null && ip.contains(",")) {
            final String[] ips = ip.trim().split(",");
            for (String subIp : ips) {
                if (isNotUnknown(subIp)) {
                   return subIp;
                }
            }
        }
        return ip;
    }

    /**
     * 获取请求
     *
     * @return HttpServletRequest 请求
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (!(requestAttributes instanceof ServletRequestAttributes)) {
            return null;
        }
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    /**
     * IP 字符串是否为空 或 "" 或 "unknown"
     *
     * @param ip ip
     * @return IP 字符串是否为空 或 "" 或 "unknown"
     */
    private static boolean isUnknown(String ip) {
        return ip == null || "".equals(ip) || "unknown".equalsIgnoreCase(ip);
    }

    /**
     * IP 字符串是否不为 空 或 "" 或 "unknown"
     *
     * @param ip ip
     * @return IP 字符串是否不为 空 或 "" 或 "unknown"
     */
    private static boolean isNotUnknown(String ip) {
        return !isUnknown(ip);
    }

}

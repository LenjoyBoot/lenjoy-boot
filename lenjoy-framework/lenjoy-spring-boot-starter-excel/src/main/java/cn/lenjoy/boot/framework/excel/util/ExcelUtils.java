package cn.lenjoy.boot.framework.excel.util;

import cn.lenjoy.boot.framework.excel.core.LenjoyReadListener;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.alibaba.fastjson2.JSON;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @description: Excel 工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class ExcelUtils {

    private ExcelUtils(){}

    /**
     * 将列表以 Excel 响应给前端
     *
     * @param response 响应
     * @param filename 文件名
     * @param sheetName Excel sheet 名
     * @param head Excel head 头
     * @param data 数据列表哦
     * @param <T> 泛型，保证 head 和 data 类型的一致性
     * @throws IOException 写入失败的情况
     */
    public static <T> void write(HttpServletResponse response, String filename, String sheetName, Class<T> head, List<T> data) throws IOException {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8").replace("+", "%20") + ".xlsx");
            // 创建写
            EasyExcelFactory.write(response.getOutputStream(), head)
                .autoCloseStream(Boolean.FALSE)
                // 取最长列的宽度作为宽度,最大 255
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet(sheetName)
                .doWrite(data);
        } catch (Exception e) {
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> errorMap = MapUtils.newHashMap();
            errorMap.put("status", "failure");
            errorMap.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(errorMap));
        }
    }
    
    public static <T> List<T> read(MultipartFile file, Class<T> head, LenjoyReadListener<T> listener) throws IOException {
        return EasyExcelFactory.read(file.getInputStream(), head, listener)
                .autoCloseStream(Boolean.FALSE)
                .doReadAllSync();
    }

}

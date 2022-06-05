package cn.lenjoy.boot.test.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @description: 测试类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@Getter
@Setter
public class NewClass {
    @ExcelProperty("字符串标题A")
    private String a;
    @ExcelProperty("字符串标题B")
    private String b;
}

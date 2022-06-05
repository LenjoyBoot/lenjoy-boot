package cn.lenjoy.boot.test.controller;

import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.excel.core.LenjoyReadListener;
import cn.lenjoy.boot.framework.excel.util.ExcelUtils;
import cn.lenjoy.boot.test.dto.NewClass;
import com.alibaba.fastjson2.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 04 星期六
 * @version: 1.0.0
 */
@Slf4j
@Api(tags = "test")
@RestController
@RequestMapping(value = "")
public class TestController {

    @GetMapping(value = "")
    @ApiOperation(tags = "test", value = "value", notes = "notes")
    public String test() {
        AssertUtils.isTrue(true, "true");
        return JSON.toJSONString("true");
    }

    @GetMapping(value = "write")
    @ApiOperation(tags = "write", value = "value", notes = "notes")
    public String write(HttpServletResponse response) throws IOException {
        List<NewClass> list = new ArrayList<>();
        NewClass aClass = new NewClass();
        aClass.setA("a");
        aClass.setB("b");
        list.add(aClass);
        ExcelUtils.write(response, "filename", "sheetname", NewClass.class, list);
        return JSON.toJSONString("true");
    }

    @GetMapping(value = "read")
    @ApiOperation(tags = "read", value = "value", notes = "notes")
    public String read(MultipartFile file) throws IOException {
        List<NewClass> list = ExcelUtils.read(file, NewClass.class, new LenjoyReadListener<NewClass>() {
            @Override
            public void invokeMethod(List<NewClass> cachedDataList) {
                cachedDataList.forEach(data -> log.info("data: {}", JSON.toJSONString(data)));
            }
        });
        return JSON.toJSONString(list);
    }
}

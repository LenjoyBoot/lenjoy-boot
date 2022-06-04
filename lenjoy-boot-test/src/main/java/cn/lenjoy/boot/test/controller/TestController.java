package cn.lenjoy.boot.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 04 星期六
 * @version: 1.0.0
 */
@Api(tags = "test")
@RestController
@RequestMapping(value = "")
public class TestController {

    @GetMapping(value = "")
    @ApiOperation(tags = "test", value = "value", notes = "notes")
    public String test() {
        return "test";
    }

}

package cn.lenjoy.boot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @description: lenjoy application 引导类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 19 星期二
 * @version: 1.0.0
 */
@EnableOpenApi
@SpringBootApplication(scanBasePackages = {"cn.lenjoy.boot"})
public class LenjoyBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(LenjoyBootApplication.class, args);
    }
}

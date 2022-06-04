package cn.lenjoy.boot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @description:
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 17 星期日
 * @version: 1.0.0
 */
@EnableOpenApi
@SpringBootApplication
public class LenjoyTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(LenjoyTestApplication.class, args);
    }
}

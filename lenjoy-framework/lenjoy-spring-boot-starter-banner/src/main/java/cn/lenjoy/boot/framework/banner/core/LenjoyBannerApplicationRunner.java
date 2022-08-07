package cn.lenjoy.boot.framework.banner.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @description: 系统启动项
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 07 星期日
 * @version: 1.0.0
 */
@SuppressWarnings("all")
@Slf4j
public class LenjoyBannerApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // application run
        log.info("\n----------------------------------------------------------\n\t" +
                "乐享开源 lenjoy open source \n\t" +
                "URL (https://github.com/LenjoyBoot/lenjoy-boot) \n\t" +
                "URL (https://gitee.com/LenjoyBoot/lenjoy-boot) \n\t" +
                "MIT License | Copyright (c) 2022 lenjoy-boot (https://lenjoy.gitee.io) \n\t" +
                "\n {} \n\t",
                "lenjoy boot application start up success!!!"
        );
    }
}

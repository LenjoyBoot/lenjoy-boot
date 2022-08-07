package cn.lenjoy.boot.generate;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;

import java.io.File;
import java.util.Objects;

/**
 * @Description: mybatis-plus 代码生成器
 * @Author: bincloud, mvpzhou
 * @Date: Create By bincloud, mvpzhou on 2022/2/14
 */
public class MybatisPlusGenerator {
    /**
     * 作者
     */
    private static final String AUTHOR = "lenjoy zhou";
    /**
     * 表名前缀
     */
    private static final String PREFIX = "sys_";
    /**
     * 模块名称
     */
    private static final String MODULE = "system";
    /**
     * 包名
     */
    private static final String PACKAGE = "cn.lenjoy.boot";
    /**
     * MAPPER
     */
    private static final String MAPPER = "mapper";
    /**
     * SERVICE
     */
    private static final String SERVICE = "service";
    /**
     * SERVICE IMPL
     */
    private static final String SERVICE_IMPL = "service.impl";


    /**
     * DB_URL
     */
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/lenjoy_boot?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    /**
     * DB_USERNAME
     */
    private static final String DB_USERNAME = "root";
    /**
     * DB_PASSWORD
     */
    private static final String DB_PASSWORD = "123456";

    /**
     * OUTPUT DIR
     */
    private static final String OUT_PUT_DIR;


    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG;

    static {
        DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(DB_URL, DB_USERNAME, DB_PASSWORD);
        OUT_PUT_DIR = getDir();
    }

    private static String getDir() {
        File file = new File(Objects.requireNonNull(MybatisPlusGenerator.class.getResource("/")).getPath());
        return file.getPath();
    }

    public static void main(String[] args) {
        FastAutoGenerator
                .create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> builder
                        .author(AUTHOR)
                        .outputDir(OUT_PUT_DIR)
                        .disableOpenDir()
                )
                .packageConfig(builder -> builder
                        .parent(PACKAGE)
                        .moduleName(MODULE)
                        .service(SERVICE)
                        .serviceImpl(SERVICE_IMPL)
                        .mapper(MAPPER)
                )
                .strategyConfig(builder -> builder
                        .likeTable(new LikeTable(PREFIX))
                        .entityBuilder()
                        .superClass(BaseEntity.class)
                        .fileOverride()
                        .enableLombok()
                        .enableTableFieldAnnotation()
                        .disableSerialVersionUID()
                        .enableChainModel()
                )
                .execute();
    }
}

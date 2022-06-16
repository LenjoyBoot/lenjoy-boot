/**
 * @description: 通用 mybatis 封装
 * 1.mybatis
 * 2.mybatis-plus
 * 3.lenjoy mybatis-plus 乐享对mybatis-plus进行扩展封装
 *
 * 多租户设计(V1.0.0暂不进行实现，未来实现)
 * 1.分库(可通过多数据源实现)
 * 1.1 dynamic-datasource-spring-boot-starter 多数据源支持,需排除默认数据库连接池实现,例如druid
 * 2.分表(可通过表前缀策略实现)
 * 3.同库同表(可通过租户编号实现)
 *
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
package cn.lenjoy.boot.framework.mybatis;

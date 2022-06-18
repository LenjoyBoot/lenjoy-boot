package cn.lenjoy.boot.framework.mybatis.core.mapper;

import cn.lenjoy.boot.framework.common.base.request.PageReq;
import cn.lenjoy.boot.framework.common.base.response.PageRes;
import cn.lenjoy.boot.framework.mybatis.core.constant.SqlConstant;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Collection;

/**
 * @description: 乐享 MyBatis Plus 操作能力拓展
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 16 星期四
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public interface LenjoyBaseMapper<T> extends BaseMapper<T> {

    /**
     * 分页查询
     * @param pageReq 分页
     * @param queryWrapper 条件
     * @return 分页数据
     */
    default PageRes<T> selectPage(PageReq pageReq, Wrapper<T> queryWrapper) {
        IPage<T> iPage = new Page<>(pageReq.getPageNo(), pageReq.getPageSize());
        selectPage(iPage, queryWrapper);
        return new PageRes<>(pageReq.getPageNo(), pageReq.getPageSize(), iPage.getPages(), iPage.getTotal(), iPage.getRecords());
    }

    /**
     * 默认查询一条数据
     * @param queryWrapper 查询条件
     * @return 单条数据，可能为null
     */
    default T limitOne(Wrapper<T> queryWrapper) {
        return selectOne(new QueryWrapper<T>().last(SqlConstant.LIMIT_1));
    }

    /**
     * 逐条插入
     * @param entities 实体集合
     */
    default void insertBatch(Collection<T> entities) {
        entities.forEach(this::insert);
    }
}

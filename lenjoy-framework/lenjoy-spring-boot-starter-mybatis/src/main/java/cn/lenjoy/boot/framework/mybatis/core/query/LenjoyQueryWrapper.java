package cn.lenjoy.boot.framework.mybatis.core.query;

import cn.lenjoy.boot.framework.common.util.array.ArrayUtil;
import cn.lenjoy.boot.framework.common.util.collection.CollectionUtils;
import cn.lenjoy.boot.framework.common.util.object.ObjectUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Collection;

/**
 * @description: 乐享 QueryWrapper 操作能力拓展
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 18 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class LenjoyQueryWrapper<T> extends QueryWrapper<T> {

    public LenjoyQueryWrapper<T> likeIfPresent(String column, String val) {
        if (StringUtils.isNotBlank(val)) {
            return (LenjoyQueryWrapper<T>) super.like(column, val);
        }
        return this;
    }
    
    public LenjoyQueryWrapper<T> inIfPresent(String column, Collection<?> values) {
        if (CollectionUtils.isNotEmpty(values)) {
            return (LenjoyQueryWrapper<T>) super.in(column, values);
        }
        return this;
    }

    public LenjoyQueryWrapper<T> inIfPresent(String column, Object... values) {
        if (ArrayUtil.isNotEmpty(values)) {
            return (LenjoyQueryWrapper<T>) super.in(column, values);
        }
        return this;
    }

    public LenjoyQueryWrapper<T> eqIfPresent(String column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyQueryWrapper<T>) super.eq(column, val);
        }
        return this;
    }

    public LenjoyQueryWrapper<T> neIfPresent(String column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyQueryWrapper<T>) super.ne(column, val);
        }
        return this;
    }

    public LenjoyQueryWrapper<T> gtIfPresent(String column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyQueryWrapper<T>) super.gt(column, val);
        }
        return this;
    }
    
    public LenjoyQueryWrapper<T> geIfPresent(String column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyQueryWrapper<T>) super.ge(column, val);
        }
        return this;
    }

    public LenjoyQueryWrapper<T> ltIfPresent(String column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyQueryWrapper<T>) super.lt(column, val);
        }
        return this;
    }

    public LenjoyQueryWrapper<T> leIfPresent(String column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyQueryWrapper<T>) super.le(column, val);
        }
        return this;
    }

    public LenjoyQueryWrapper<T> betweenIfPresent(String column, Object val1, Object val2) {
        if (ObjectUtils.isNotEmpty(val1) && ObjectUtils.isNotEmpty(val2)) {
            return (LenjoyQueryWrapper<T>) super.between(column, val1, val2);
        }
        if (ObjectUtils.isNotEmpty(val1)) {
            return (LenjoyQueryWrapper<T>) ge(column, val1);
        }
        if (ObjectUtils.isNotEmpty(val2)) {
            return (LenjoyQueryWrapper<T>) le(column, val2);
        }
        return this;
    }

}

package cn.lenjoy.boot.framework.mybatis.core.query;

import cn.lenjoy.boot.framework.common.util.array.ArrayUtil;
import cn.lenjoy.boot.framework.common.util.collection.CollectionUtils;
import cn.lenjoy.boot.framework.common.util.object.ObjectUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.Collection;

/**
 * @description: 乐享 LambdaQueryWrapper 操作能力拓展
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 18 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class LenjoyLambdaQueryWrapper<T> extends LambdaQueryWrapper<T> {
    
    public LenjoyLambdaQueryWrapper<T> likeIfPresent(SFunction<T, ?> column, String val) {
        if (StringUtils.isNotBlank(val)) {
            return (LenjoyLambdaQueryWrapper<T>) super.like(column, val);
        }
        return this;
    }

    public LenjoyLambdaQueryWrapper<T> inIfPresent(SFunction<T, ?> column, Collection<?> values) {
        if (CollectionUtils.isNotEmpty(values)) {
            return (LenjoyLambdaQueryWrapper<T>) super.in(column, values);
        }
        return this;
    }

    public LenjoyLambdaQueryWrapper<T> inIfPresent(SFunction<T, ?> column, Object... values) {
        if (ArrayUtil.isNotEmpty(values)) {
            return (LenjoyLambdaQueryWrapper<T>) super.in(column, values);
        }
        return this;
    }

    public LenjoyLambdaQueryWrapper<T> eqIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyLambdaQueryWrapper<T>) super.eq(column, val);
        }
        return this;
    }

    public LenjoyLambdaQueryWrapper<T> neIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyLambdaQueryWrapper<T>) super.ne(column, val);
        }
        return this;
    }

    public LenjoyLambdaQueryWrapper<T> gtIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyLambdaQueryWrapper<T>) super.gt(column, val);
        }
        return this;
    }

    public LenjoyLambdaQueryWrapper<T> geIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyLambdaQueryWrapper<T>) super.ge(column, val);
        }
        return this;
    }

    public LenjoyLambdaQueryWrapper<T> ltIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyLambdaQueryWrapper<T>) super.lt(column, val);
        }
        return this;
    }

    public LenjoyLambdaQueryWrapper<T> leIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtils.isNotEmpty(val)) {
            return (LenjoyLambdaQueryWrapper<T>) super.le(column, val);
        }
        return this;
    }

    public LenjoyLambdaQueryWrapper<T> betweenIfPresent(SFunction<T, ?> column, Object val1, Object val2) {
        if (ObjectUtils.isNotEmpty(val1) && ObjectUtils.isNotEmpty(val2)) {
            return (LenjoyLambdaQueryWrapper<T>) super.between(column, val1, val2);
        }
        if (ObjectUtils.isNotEmpty(val1)) {
            return (LenjoyLambdaQueryWrapper<T>) ge(column, val1);
        }
        if (ObjectUtils.isNotEmpty(val2)) {
            return (LenjoyLambdaQueryWrapper<T>) le(column, val2);
        }
        return this;
    }
}

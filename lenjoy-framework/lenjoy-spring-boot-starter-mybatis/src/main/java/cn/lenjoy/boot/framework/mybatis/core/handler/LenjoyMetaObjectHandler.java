package cn.lenjoy.boot.framework.mybatis.core.handler;

import cn.lenjoy.boot.framework.common.util.user.LenjoyUserThreadLocalHolder;
import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @description: 乐享自动注入表单属性实现
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 15 星期三
 * @version: 1.0.0
 */
public class LenjoyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();
            LocalDateTime now = LocalDateTime.now();
            // 设置创建时间
            if (Objects.isNull(baseEntity.getCreateTime())) {
                baseEntity.setCreateTime(now);
            }
            // 设置修改时间
            if (Objects.isNull(baseEntity.getUpdateTime())) {
                baseEntity.setUpdateTime(now);
            }

            String username = LenjoyUserThreadLocalHolder.getUsername();
            // 设置创建人
            if (Objects.isNull(baseEntity.getCreateBy()) && Objects.nonNull(username)) {
                baseEntity.setCreateBy(username);
            }
            // 设置修改人
            if (Objects.isNull(baseEntity.getUpdateBy()) && Objects.nonNull(username)) {
                baseEntity.setUpdateBy(username);
            }

        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 设置修改时间
        Object modifyTime = getFieldValByName("modifyTime", metaObject);
        if (Objects.isNull(modifyTime)) {
            setFieldValByName("modifyTime", LocalDateTime.now(), metaObject);
        }
        // 设置修改人
        Object modifyBy = getFieldValByName("modifyBy", metaObject);
        String username = LenjoyUserThreadLocalHolder.getUsername();
        if (Objects.isNull(modifyBy) && Objects.nonNull(username)) {
            setFieldValByName("modifyBy", LocalDateTime.now(), metaObject);
        }
    }
}

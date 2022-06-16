package cn.lenjoy.boot.framework.mybatis.core.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description: 实体映射基类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 15 星期三
 * @version: 1.0.0
 */
@Getter
@Setter
public abstract class BaseEntity implements Serializable {
    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 修改人
     */
    @TableField(value = "modify_by", fill = FieldFill.INSERT_UPDATE)
    private String modifyBy;
    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;
    /**
     * 是否删除
     */
    @TableLogic
    private Boolean deleted;
}

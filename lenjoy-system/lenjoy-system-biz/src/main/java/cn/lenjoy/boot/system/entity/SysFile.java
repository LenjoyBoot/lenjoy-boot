package cn.lenjoy.boot.system.entity;

import cn.lenjoy.boot.framework.mybatis.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文件表
 * </p>
 *
 * @author lenjoy zhou
 * @since 2022-08-07
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_file")
public class SysFile extends BaseEntity {

    /**
     * 预览文件ID(唯一)
     */
    @TableField("review_id")
    private String reviewId;

    /**
     * 业务类型
     */
    @TableField("type")
    private String type;

    /**
     * 业务子类型
     */
    @TableField("sub_type")
    private String subType;

    /**
     * 文件名称
     */
    @TableField("name")
    private String name;

    /**
     * 文件大小
     */
    @TableField("size")
    private Long size;

    /**
     * 存储地址(远程)
     */
    @TableField("remote")
    private String remote;

    /**
     * 存储地址(本地)
     */
    @TableField("location")
    private String location;

    /**
     * 加密盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 是否加密(0:未加密1:加密)
     */
    @TableField("encrypted")
    private Integer encrypted;


}

package cn.lenjoy.boot.framework.common.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 分页结果类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@Data
@ApiModel("分页结果")
@SuppressWarnings("unused")
public final class PageRes<T> implements Serializable {

    @ApiModelProperty(value = "当前页码")
    private Long pageNo;

    @ApiModelProperty(value = "每页条数")
    private Long pageSize;

    @ApiModelProperty(value = "页码总数")
    private Long totalPage;

    @ApiModelProperty(value = "数据总数")
    private Long total;

    @ApiModelProperty(value = "分页数据")
    private transient List<T> list;

    public PageRes(Long pageNo, Long pageSize, Long totalPage, Long total, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.total = total;
        this.list = list;
    }

    public static <T> PageRes<T> emptyPageRes(Long pageNo, Long pageSize) {
        return new PageRes<>(pageNo, pageSize, 0L, 0L, new ArrayList<>());
    }
}

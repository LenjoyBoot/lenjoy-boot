package cn.lenjoy.boot.framework.common.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: 分页请求参数
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "分页请求参数")
public class PageReq extends BaseReq implements Serializable {
    private static final long PAGE_NO = 1L;
    private static final long PAGE_SIZE = 10L;

    @ApiModelProperty(value = "当前页码,默认 1 开始", required = true, example = "1")
    @NotNull(message = "当前页码,不能为空")
    @Min(value = 1, message = "页码最小值为 1")
    private Long pageNo = PAGE_NO;

    @ApiModelProperty(value = "每页条数,默认 10,最大值为 500", required = true, example = "10")
    @NotNull(message = "每页条数,不能为空")
    @Min(value = 1, message = "条数,最小值为 1")
    @Max(value = 500, message = "条数,最大值为 500")
    private Long pageSize = PAGE_SIZE;
}

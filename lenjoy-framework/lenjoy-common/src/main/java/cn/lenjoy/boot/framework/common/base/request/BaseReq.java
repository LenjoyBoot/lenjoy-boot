package cn.lenjoy.boot.framework.common.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description: 请求参数
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@Getter
@Setter
@ApiModel(value = "请求参数")
public class BaseReq implements Serializable {
    private static final String REQ_ID = "32bit-uuid";

    @ApiModelProperty(value = "请求Id", required = true, example = "32bit-uuid")
    private String reqId = REQ_ID;
}

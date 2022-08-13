package cn.lenjoy.boot.system.controller.admin.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * @description: 登录返回数据VO
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 07 星期日
 * @version: 1.0.0
 */
@ApiModel("管理后台-登录返回数据VO")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginResVO {

    @ApiModelProperty(value = "用户ID", required = true, example = "1024")
    private Long id;

    @ApiModelProperty(value = "访问令牌", required = true, example = "session")
    private String accessToken;

    @ApiModelProperty(value = "刷新令牌", required = true, example = "once")
    private String refreshToken;

    @ApiModelProperty(value = "会话过期时间", required = true)
    private Date expireTime;

}

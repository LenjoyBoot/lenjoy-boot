package cn.lenjoy.boot.system.controller.admin.auth.vo;

import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @description: 用户名密码登录入参
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 13 星期六
 * @version: 1.0.0
 */
@ApiModel(value = "用户名密码登录入参", description = "用户名+密码（rsa加密），如需要CAS认证，需携带CAS token")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginReqVO {
    @ApiModelProperty(value = "用户名", required = true, example = "5201314")
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 6, max = 18, message = "用户名长度为 6-18 位")
    @Pattern(regexp = "^[A-Za-z0-9]\\w+$", message = "用户名格式为数字、字母开头，运行下划线")
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "********")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 8, max = 24, message = "密码长度为 8-24 位")
    private String password;

    // ========== 图形验证码相关 ==========

    @ApiModelProperty(value = "验证码", required = true, example = "2048", notes = "验证码可能关闭验证")
    @NotBlank(message = "验证码不能为空")
    private String code;

    // ========== 社交平台认证相关 ==========

    @ApiModelProperty(value = "社交平台登录类型", required = true, example = "0", notes = "参见 SysUserSocialTypeEnum 枚举值")
    private Integer socialType;

    @ApiModelProperty(value = "社交平台授权码", required = true, example = "uuid 32bit")
    private String socialCode;

    @ApiModelProperty(value = "社交平台state", required = true, example = "uuid 32bit")
    private String socialState;

    @AssertTrue(message = "授权码不可为空")
    public boolean isCasTokenValid() {
        return socialType == null || StringUtils.isNotBlank(socialCode);
    }

}

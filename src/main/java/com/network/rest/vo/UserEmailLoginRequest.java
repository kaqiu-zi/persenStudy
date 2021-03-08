package com.network.rest.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * {@link } 通用请求
 *
 * @author kaqiu
 * @version 1.0, 2021/3/4
 * @since 1.0.0
 */
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEmailLoginRequest {
    /** 邮箱 */
    @ApiModelProperty(value = "邮箱", required = true, example = "123@net.com")
    @Email
    private String email;
    /** 密码 */
    @ApiModelProperty(value = "密码", required = true, example = "1")
    @NotBlank
    private String password;
}

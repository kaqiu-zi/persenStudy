package com.network.rest.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * {@link } 通用请求
 *
 * @author kaqiu
 * @version 1.0, 2021/3/4
 * @since 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@Data
@Builder
public class UserResetRequest {
    /** id */
    @ApiModelProperty(value = "id", required = true, example = "1")
    @NotNull
    private Integer id;
    /** 数据项 */
    @ApiModelProperty(value = "数据", required = true, example = "data")
    @NotBlank
    private String data;
}

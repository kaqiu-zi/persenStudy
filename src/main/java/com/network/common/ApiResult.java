package com.network.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 返回值包装类
 *
 * @author kaqiu-omj
 * @version 1.0 2020/12/23 15:27
 * @since 1.0.0
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult<T> {

    private boolean success;

    private int errorCode;

    private T date;

    private String errorMsg;

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, 0, data, "error_code.ok");
    }

    public static <T> ApiResult<T> success() {
        return new ApiResult<>(true, 0, null, "error_code.ok");
    }

    
}

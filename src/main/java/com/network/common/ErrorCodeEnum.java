package com.network.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误代码枚举
 *
 * @author mingJie-Ou
 * @version 1.0 2021/3/8
 * @since 1.0.0
 */
@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {
    /** 成功 */
    OK(0, "error_code.ok"),
    UNKNOWN_ERROR(1, "error_code.unknown_error"),
    BAD_REQUEST(2, "error_code.bad_request"),
    UNAUTHORIZED(3, "error_code.unauthorized"),
    FORBIDDEN(4, "error_code.forbidden"),
    METHOD_NOT_ALLOWED(5, "error_code.method_not_allowed"),
    RETRY(6, "error_code.retry"),
    TIMEOUT(7, "error_code.timeout"),
    RATE_LIMITER_EXCEEDED(8, "error_code.rate_limiter_exceeded"),
    INVALID_VERSION(9, "error_code.invalid_version"),
    SERVICE_RATE_LIMITER_EXCEEDED(10, "error_code.service_rate_limiter_exceeded"),
    VERSION_TOO_LOW(11, "error_code.version_too_low"),
    FUNCTION_PAUSE_TEMPORARY(12, "error_code.function_pause_temporary"),

    /** 正常业务错误 */
    EMAIL_ALREADY_EXIST(100, "error_code.email_already_exist"),
    USERNAME_ALREADY_EXIST(101, "error_code.username_already_exist"),
    NICKNAME_ALREADY_EXIST(102, "error_code.nickname_already_exist"),
    EMAIL_NOT_EXIST(103, "error_code.email_not_exist");

    private final int errorCode;
    private final String errorMessage;
}

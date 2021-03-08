package com.network.common.exception;

import com.network.common.ErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 业务错误
 *
 * @author mingJie-Ou
 * @version 1.0 2021/3/8
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
public class BusinessException extends RuntimeException {

    /** 错误码 */
    private ErrorCodeEnum errorCode;
    /** i18n参数 */
    private Object[] args;

    /**
     * 构造业务异常
     *
     * @param errorCode 错误码
     * @param args      i18n参数
     */
    public BusinessException(ErrorCodeEnum errorCode, Object... args) {
        super(errorCode.getErrorCode() + "," + errorCode.getErrorMessage(), null, true, false);
        this.errorCode = errorCode;
        this.args = args;
    }
}

package com.woorinpang.settlementservice.global.exception;

import com.woorinpang.settlementservice.global.exception.dto.ErrorCode;

public class EnumTypeMismatchException extends BusinessException {

    public EnumTypeMismatchException(String message) {
        super(ErrorCode.INVALID_TYPE_VALUE, message);
    }
}

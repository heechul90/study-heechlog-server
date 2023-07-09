package com.woorinpang.settlementservice.global.exception;

import com.woorinpang.settlementservice.global.exception.dto.ErrorCode;

public class JsonInvalidRequestException extends BusinessException {

    public JsonInvalidRequestException(ErrorCode errorCode, String customMessage) {
        super(errorCode, customMessage);
    }
}
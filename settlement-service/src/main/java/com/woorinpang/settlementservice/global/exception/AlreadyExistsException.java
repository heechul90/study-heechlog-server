package com.woorinpang.settlementservice.global.exception;

import com.woorinpang.settlementservice.global.exception.dto.ErrorCode;

public class AlreadyExistsException extends BusinessException {

    public AlreadyExistsException(String message) {
        super(ErrorCode.ENTITY_ALREADY_EXISTS, message);
    }
}

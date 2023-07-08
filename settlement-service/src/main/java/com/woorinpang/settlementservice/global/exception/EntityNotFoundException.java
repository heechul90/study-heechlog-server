package com.woorinpang.settlementservice.global.exception;

import com.woorinpang.settlementservice.global.exception.dto.ErrorCode;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String message) {
        super(ErrorCode.ENTITY_NOT_FOUND, message);
    }
}

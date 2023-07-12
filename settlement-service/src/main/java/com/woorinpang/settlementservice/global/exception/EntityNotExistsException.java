package com.woorinpang.settlementservice.global.exception;

import com.woorinpang.settlementservice.global.exception.dto.ErrorCode;

public class EntityNotExistsException extends BusinessException {

    public EntityNotExistsException(String message) {
        super(ErrorCode.ENTITY_NOT_EXISTS, message);
    }
}

package com.woorinpang.settlementservice.global.exception;

import com.woorinpang.settlementservice.global.exception.dto.ErrorCode;

public class EntityAlreadyExistsException extends BusinessException {

    public EntityAlreadyExistsException(String message) {
        super(ErrorCode.ENTITY_ALREADY_EXISTS, message);
    }
}

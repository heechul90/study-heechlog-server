package com.woorinpang.settlementservice.application.settlement.api.global.exception;

import lombok.Getter;

@Getter
public class SettlementApiException extends RuntimeException {
    private final ErrorType errorType;
    private final Object error;

    public SettlementApiException(String message, ErrorType errorType, Object error) {
        super(message);
        this.errorType = errorType;
        this.error = error;
    }

    public SettlementApiException(Object error) {
        this.errorType = ErrorType.INVALID_INPUT_VALUE;
        this.error = error;
    }
}

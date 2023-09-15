package com.woorinpang.settlementservice.application.settlement.api.global.exception;

public class SettlementApiException extends RuntimeException {
    private final ErrorType errorType;
    private final Object data;

    public SettlementApiException(String message, ErrorType errorType, Object data) {
        super(message);
        this.errorType = errorType;
        this.data = data;
    }
}

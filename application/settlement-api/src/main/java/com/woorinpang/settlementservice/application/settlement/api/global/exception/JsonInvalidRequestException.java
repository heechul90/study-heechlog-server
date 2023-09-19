package com.woorinpang.settlementservice.application.settlement.api.global.exception;

public class JsonInvalidRequestException extends SettlementApiException {
    public JsonInvalidRequestException(Object data) {
        super(data);
    }
}

package com.woorinpang.settlementservice.application.settlement.api.global.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorMessage {
    private String code;
    private String message;
    private Object data;

    private ErrorMessage(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ErrorMessage of(String code, String message) {
        return new ErrorMessage(code, message, null);
    }

    public static ErrorMessage of(String code, String message, Object data) {
        return new ErrorMessage(code, message, data);
    }
}

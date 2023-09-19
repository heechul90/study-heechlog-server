package com.woorinpang.settlementservice.application.settlement.api.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, ErrorCode.E400, "error.invalid.input.value", LogLevel.ERROR), //Bad Request
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, ErrorCode.E400, "error.invalid.type.value", LogLevel.ERROR), //Bad Request
    ;

    private final HttpStatus httpStatus;
    private final ErrorCode errorCode;
    private final String message;
    private final LogLevel logLevel;
}

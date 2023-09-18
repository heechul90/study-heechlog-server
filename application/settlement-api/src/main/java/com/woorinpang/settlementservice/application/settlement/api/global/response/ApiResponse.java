package com.woorinpang.settlementservice.application.settlement.api.global.response;

import com.woorinpang.settlementservice.application.settlement.api.global.exception.ErrorMessage;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private final LocalDateTime timestamp;
    private final ResultType resultType;
    private final ErrorMessage errorMessage;
    private final T data;

    public ApiResponse(ResultType resultType, ErrorMessage errorMessage, T data) {
        this.timestamp = LocalDateTime.now();
        this.resultType = resultType;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public static ApiResponse<?> success() {
        return new ApiResponse<>(ResultType.SUCCESS, null, null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResultType.SUCCESS, null, data);
    }

    public static ApiResponse<?> error() {
        return new ApiResponse<>(ResultType.ERROR, null, null);
    }

    public static ApiResponse<?> error(Object data) {
        return new ApiResponse<>(ResultType.ERROR, null, data);
    }
}

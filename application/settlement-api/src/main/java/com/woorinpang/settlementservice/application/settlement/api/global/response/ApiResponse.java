package com.woorinpang.settlementservice.application.settlement.api.global.response;

import com.woorinpang.settlementservice.application.settlement.api.global.error.ErrorMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private final LocalDateTime timestamp;
    private final ResultType result;
    private final ErrorMessage error;
    private final T data;

    public ApiResponse(ResultType result, ErrorMessage error, T data) {
        this.timestamp = LocalDateTime.now();
        this.result = result;
        this.error = error;
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
}

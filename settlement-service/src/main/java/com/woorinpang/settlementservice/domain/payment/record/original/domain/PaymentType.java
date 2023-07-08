package com.woorinpang.settlementservice.domain.payment.record.original.domain;

import com.woorinpang.settlementservice.domain.payment.record.original.application.exception.PaymentTypeMismatchException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PaymentType {
    GENERAL("GENERAL", "일반 결제"),
    CANCEL("CANCEL", "취소 결제"),
    ADMIN("ADMIN", "관리자 등록"),
    ;

    private final String code;
    private final String description;

    public static PaymentType findByCode(String code) {
        return Arrays.stream(PaymentType.values())
                .filter(type -> type.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new PaymentTypeMismatchException(code));
    }
}

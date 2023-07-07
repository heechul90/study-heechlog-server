package com.woorinpang.settlementservice.domain.payment.record.original.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
    GENERAL("GENERAL", "일반 결제"),
    CANCEL("CANCEL", "취소 결제"),
    ;

    private final String code;
    private final String description;
}

package com.woorinpang.settlementservice.storage.main.db.entity.payment.record.original;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
    GENERAL("GENERAL", "일반 결제"),
    CANCEL("CANCEL", "취소 결제"),
    ADMIN("ADMIN", "관리자 등록"),
    ;

    private final String code;
    private final String description;
}

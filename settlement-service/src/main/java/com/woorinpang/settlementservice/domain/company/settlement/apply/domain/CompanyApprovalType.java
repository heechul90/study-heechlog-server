package com.woorinpang.settlementservice.domain.company.settlement.apply.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CompanyApprovalType {
    READY("READY", "결재 준비"),
    REQUEST("REQUEST", "결재 요청"),
    COMPLETE("COMPLETE", "결재 완료"),
    REJECT("REJECT", "결재 거절");

    private final String code;
    private final String description;
}

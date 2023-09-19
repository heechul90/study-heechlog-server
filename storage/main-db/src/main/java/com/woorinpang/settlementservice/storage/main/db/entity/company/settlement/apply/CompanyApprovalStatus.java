package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.apply;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CompanyApprovalStatus {
    READY("READY", "결재 준비"),
    REQUEST("REQUEST", "결재 요청"),
    COMPLETE("COMPLETE", "결재 완료"),
    REJECT("REJECT", "결재 거절");

    private final String code;
    private final String description;
}

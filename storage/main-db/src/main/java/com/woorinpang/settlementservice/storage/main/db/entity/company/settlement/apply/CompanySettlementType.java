package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.apply;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CompanySettlementType {
    PLATFORM("PLATFORM", "플랫폼 정산"),
    DIRECT("DIRECT", "직접 정산"),
    ;

    private final String code;
    private final String description;
}

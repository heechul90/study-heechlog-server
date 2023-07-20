package com.woorinpang.settlementservice.domain.company.settlement.apply.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CompanySettlementType {
    WOORINPANG("WOORINPANG", "우린팡 플랫폼 정산"),
    DIRECT("DIRECT", "직접 정산"),
    ;

    private final String code;
    private final String description;
}

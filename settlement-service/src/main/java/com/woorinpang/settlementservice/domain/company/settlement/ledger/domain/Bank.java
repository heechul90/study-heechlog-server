package com.woorinpang.settlementservice.domain.company.settlement.ledger.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Bank {
    NH("NH", "농협"),
    ;

    private final String code;
    private final String description;
}

package com.woorinpang.settlementservice.domain.bank.statement.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransactionType {
    DEPOSIT("DEPOSIT", "입금"),
    WITHDRAW("WITHDRAW", "출금");

    private final String code;
    private final String description;
}

package com.woorinpang.settlementservice.common.enums.code.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StoreCode {
    CODE1("code1", "코드1"),
    ;

    private final String code;
    private final String description;
}

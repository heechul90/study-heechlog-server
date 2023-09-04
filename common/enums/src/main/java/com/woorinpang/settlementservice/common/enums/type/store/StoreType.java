package com.woorinpang.settlementservice.common.enums.type.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StoreType {
    CAFE("Cafe", "카페"),
    ;

    private final String code;
    private final String description;
}

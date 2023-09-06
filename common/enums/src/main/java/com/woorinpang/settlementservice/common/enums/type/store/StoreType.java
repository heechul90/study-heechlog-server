package com.woorinpang.settlementservice.common.enums.type.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum StoreType {
    CAFE("Cafe", "카페"),
    ;

    private final String type;
    private final String description;

    public StoreType findByType(String type) {
        return Arrays.stream(StoreType.values())
                .filter(storeType -> storeType.getType().equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}

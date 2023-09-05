package com.woorinpang.settlementservice.domain.store.domain;

import lombok.Builder;

@Builder
public record Store(
        Long storeId,
        String storeName
) {
}

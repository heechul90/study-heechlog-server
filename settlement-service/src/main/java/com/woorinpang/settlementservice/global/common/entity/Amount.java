package com.woorinpang.settlementservice.global.common.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Amount {
    private long value;

    public Amount(Long value) {
        this.value = value != null ? value : 0L;
    }
}

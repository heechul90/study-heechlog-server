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

    private Amount(long value) {
        this.value = value;
    }

    public static Amount create(Long value) {
        return new Amount(value != null ? value : 0L);
    }

    public static Amount cancel(Long value) {
        return new Amount(value != null ? value * -1 : 0L);
    }
}

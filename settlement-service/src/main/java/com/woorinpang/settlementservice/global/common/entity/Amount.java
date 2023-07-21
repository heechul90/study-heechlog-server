package com.woorinpang.settlementservice.global.common.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Amount {
    public static final Amount ZERO = Amount.create(0L);

    private BigDecimal amount;

    private Amount(BigDecimal amount) {
        this.amount = amount;
    }

    public static Amount create(Long amount) {
        return new Amount(BigDecimal.valueOf(amount));
    }

    public static Amount create(BigDecimal amount) {
        return new Amount(amount);
    }

    public static Amount cancel(Long amount) {
        return new Amount(BigDecimal.valueOf(-1 * amount));
    }

    public Amount plus(Amount amount) {
        return new Amount(this.amount.add(amount.amount));
    }

    public Amount minus(Amount amount) {
        return new Amount(this.amount.subtract(amount.amount));
    }

    public Amount times(double percent) {
        return new Amount(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Amount other) {
        return this.amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Amount other) {
        return this.amount.compareTo(other.amount) >= 0;
    }
}

package com.woorinpang.settlementservice.domain.payment.domain;

import com.woorinpang.settlementservice.common.objects.YearMonthDay;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PaymentDay(
        LocalDateTime paymentDate,
        YearMonthDay paymentDateYmd
) {
}

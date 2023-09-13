package com.woorinpang.settlementservice.domain.payment.domain;

import com.woorinpang.settlementservice.common.objects.YearMonthDay;
import lombok.Builder;

@Builder
public record AddPaymentRecordCommand(
        String transactionId,
        Company company,
        Store store,
        User user,
        PaymentAmount paymentAmount,
        PaymentDay paymentDay
) {
}

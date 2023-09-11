package com.woorinpang.settlementservice.domain.payment.domain;

import lombok.Builder;

@Builder
public record AddPaymentRecordCommand(
        String transactionId,
        Company company,
        Store store,
        User user
) {
}

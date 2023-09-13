package com.woorinpang.settlementservice.domain.payment.domain;

import com.woorinpang.settlementservice.common.objects.Amount;
import lombok.Builder;

@Builder
public record PaymentAmount(
        Amount paymentAmount,
        Amount companySettlementAmount,
        Amount storeSettlementAmount

) {
}

package com.woorinpang.settlementservice.domain.payment.record.original.application.dto.command;

import com.woorinpang.settlementservice.domain.payment.record.common.domain.PaymentAmount;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public record SavePaymentOriginalRecordCommand(
        String transactionId,
        Company company,
        Store store,
        User user,
        PaymentAmount paymentAmount,
        Payment payment,
        PaymentCancellation paymentCancellation,
        PaymentType paymentType
) {
    public PaymentOriginalRecord toPaymentOriginalRecord() {
        return PaymentOriginalRecord.createPaymentOriginalRecord()
                .transactionId(this.transactionId)
                .company(this.company)
                .store(this.store)
                .user(this.user)
                .paymentAmount(this.paymentAmount)
                .payment(this.payment)
                .paymentCancellation(this.paymentCancellation)
                .paymentType(this.paymentType)
                .build();
    }
}

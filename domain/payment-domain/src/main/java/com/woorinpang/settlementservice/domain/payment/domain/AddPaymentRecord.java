package com.woorinpang.settlementservice.domain.payment.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddPaymentRecord {
    private final PaymentRecordRepository paymentRecordRepository;

    public Long add(AddPaymentRecordCommand command) {
        return this.paymentRecordRepository.add(command);
    }
}

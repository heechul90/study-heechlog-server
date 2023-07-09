package com.woorinpang.settlementservice.domain.payment.record.original.application.exception;

import jakarta.persistence.EntityNotFoundException;

public class PaymentOriginalRecordNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "PaymentOriginalRecordId=%s은 존재하지 않습니다.";

    public PaymentOriginalRecordNotFoundException(Long paymentOriginalRecordId) {
        super(MESSAGE.formatted(paymentOriginalRecordId));
    }
}

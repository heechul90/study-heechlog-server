package com.woorinpang.settlementservice.domain.payment.record.daily.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class PaymentDailyRecordNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "PaymentDailyRecordId=%s은 존재하지 않습니다.";

    public PaymentDailyRecordNotFoundException(Long paymentDailyRecordId) {
        super(MESSAGE.formatted(paymentDailyRecordId));
    }
}

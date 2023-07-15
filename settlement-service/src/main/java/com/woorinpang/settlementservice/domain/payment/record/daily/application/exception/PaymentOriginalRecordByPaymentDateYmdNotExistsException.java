package com.woorinpang.settlementservice.domain.payment.record.daily.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotExistsException;

public class PaymentOriginalRecordByPaymentDateYmdNotExistsException extends EntityNotExistsException {
    public static final String MESSAGE = "companyId=%s, storeId=%, 해당일=%s에 결제 기록이 존재하지 않습니다.";

    public PaymentOriginalRecordByPaymentDateYmdNotExistsException(Long companyId, Long storeId, String paymentDateYmd) {
        super(MESSAGE.formatted(companyId, storeId, paymentDateYmd));
    }
}

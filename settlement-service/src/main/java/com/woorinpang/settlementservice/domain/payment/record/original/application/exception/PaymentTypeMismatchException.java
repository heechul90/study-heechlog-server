package com.woorinpang.settlementservice.domain.payment.record.original.application.exception;

import com.woorinpang.settlementservice.global.exception.EnumTypeMismatchException;

public class PaymentTypeMismatchException extends EnumTypeMismatchException {
    public static final String MESSAGE = "PaymentType=%s는 없는 타입입니다.";

    public PaymentTypeMismatchException(String code) {
        super(MESSAGE.formatted(code));
    }
}

package com.woorinpang.settlementservice.domain.payment.record.original.application.exception;

import com.woorinpang.settlementservice.global.exception.AlreadyExistsException;

public class TransactionIdAlreadyExistsException extends AlreadyExistsException {
    private static final String MESSAGE = "transactionId=%s은 이미 존재합니다.";

    public TransactionIdAlreadyExistsException(String transactionId) {
        super(MESSAGE.formatted(transactionId));
    }
}

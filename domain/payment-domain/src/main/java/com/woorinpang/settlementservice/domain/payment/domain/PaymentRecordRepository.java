package com.woorinpang.settlementservice.domain.payment.domain;

public interface PaymentRecordRepository {
    Long add(AddPaymentRecordCommand addPaymentRecord);
}

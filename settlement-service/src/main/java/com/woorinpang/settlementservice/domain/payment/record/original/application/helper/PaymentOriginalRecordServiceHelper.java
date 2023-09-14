package com.woorinpang.settlementservice.domain.payment.record.original.application.helper;

import com.woorinpang.settlementservice.domain.payment.record.original.application.exception.PaymentOriginalRecordNotFoundException;
import com.woorinpang.settlementservice.domain.payment.record.original.application.exception.TransactionIdAlreadyExistsException;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecordRepository;

public final class PaymentOriginalRecordServiceHelper {
    /**
     * 결제 원본기록 단건조회
     */
    public static PaymentOriginalRecord findPaymentOriginalRecordById(PaymentOriginalRecordRepository paymentOriginalRecordRepository,
                                                               Long paymentOriginalRecordId) {
        return paymentOriginalRecordRepository.findById(paymentOriginalRecordId)
                .orElseThrow(() -> new PaymentOriginalRecordNotFoundException(paymentOriginalRecordId));
    }

    /**
     * 결제 원본기록 저장
     */
    public static PaymentOriginalRecord savePaymentOriginalRecord(PaymentOriginalRecordRepository paymentOriginalRecordRepository,
                                                           PaymentOriginalRecord paymentOriginalRecord) {
        return paymentOriginalRecordRepository.save(paymentOriginalRecord);
    }
}

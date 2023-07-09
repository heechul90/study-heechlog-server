package com.woorinpang.settlementservice.domain.payment.record.original.application.helper;

import com.woorinpang.settlementservice.domain.payment.record.original.application.exception.PaymentOriginalRecordNotFoundException;
import com.woorinpang.settlementservice.domain.payment.record.original.application.exception.TransactionIdAlreadyExistsException;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecordRepository;

public final class PaymentOriginalRecordServiceHelper {
    public static PaymentOriginalRecord findPaymentOriginalRecordById(PaymentOriginalRecordRepository paymentOriginalRecordRepository,
                                                               Long paymentOriginalRecordId) {
        return paymentOriginalRecordRepository.findById(paymentOriginalRecordId)
                .orElseThrow(() -> new PaymentOriginalRecordNotFoundException(paymentOriginalRecordId));
    }

    public static PaymentOriginalRecord savePaymentOriginalRecord(PaymentOriginalRecordRepository paymentOriginalRecordRepository,
                                                           PaymentOriginalRecord paymentOriginalRecord) {
        return paymentOriginalRecordRepository.save(paymentOriginalRecord);
    }

    public static void existsPaymentOriginalRecordByTransactionId(PaymentOriginalRecordRepository paymentOriginalRecordRepository,
                                                                  String transactionId) {
        if (paymentOriginalRecordRepository.existsByTransactionId(transactionId)) {
            throw new TransactionIdAlreadyExistsException(transactionId);
        }
    }
}

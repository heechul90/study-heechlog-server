package com.woorinpang.settlementservice.domain.payment.record.daily.application.helper;

import com.woorinpang.settlementservice.domain.payment.record.daily.application.exception.PaymentDailyRecordNotFoundException;
import com.woorinpang.settlementservice.domain.payment.record.daily.domain.PaymentDailyRecord;
import com.woorinpang.settlementservice.domain.payment.record.daily.domain.PaymentDailyRecordRepository;

public final class PaymentDailyRecordServiceHelper {
    public static PaymentDailyRecord findPaymentDailyRecordById(PaymentDailyRecordRepository paymentDailyRecordRepository,
                                                                Long paymentDailyRecordId) {
        return paymentDailyRecordRepository.findById(paymentDailyRecordId)
                .orElseThrow(() -> new PaymentDailyRecordNotFoundException(paymentDailyRecordId));
    }

    public static PaymentDailyRecord savePaymentDailyRecord(PaymentDailyRecordRepository paymentDailyRecordRepository,
                                                            PaymentDailyRecord paymentDailyRecord) {
        return paymentDailyRecordRepository.save(paymentDailyRecord);
    }

    public static void deletePaymentDailyRecord(PaymentDailyRecordRepository paymentDailyRecordRepository,
                                                PaymentDailyRecord paymentDailyRecord) {
        paymentDailyRecordRepository.delete(paymentDailyRecord);
    }
}

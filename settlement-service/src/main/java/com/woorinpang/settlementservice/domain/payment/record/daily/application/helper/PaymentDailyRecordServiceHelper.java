package com.woorinpang.settlementservice.domain.payment.record.daily.application.helper;

import com.woorinpang.settlementservice.domain.payment.record.daily.application.exception.PaymentDailyRecordNotFoundException;
import com.woorinpang.settlementservice.domain.payment.record.daily.domain.PaymentDailyRecord;
import com.woorinpang.settlementservice.domain.payment.record.daily.domain.PaymentDailyRecordRepository;

public final class PaymentDailyRecordServiceHelper {
    /**
     * 결제 일일기록 단건조회
     */
    public static PaymentDailyRecord findPaymentDailyRecordById(PaymentDailyRecordRepository paymentDailyRecordRepository,
                                                                Long paymentDailyRecordId) {
        return paymentDailyRecordRepository.findById(paymentDailyRecordId)
                .orElseThrow(() -> new PaymentDailyRecordNotFoundException(paymentDailyRecordId));
    }

    /**
     * 결제 일일기록 저장
     */
    public static PaymentDailyRecord savePaymentDailyRecord(PaymentDailyRecordRepository paymentDailyRecordRepository,
                                                            PaymentDailyRecord paymentDailyRecord) {
        return paymentDailyRecordRepository.save(paymentDailyRecord);
    }

    /**
     * 결제 일일기록 삭제
     */
    public static void deletePaymentDailyRecord(PaymentDailyRecordRepository paymentDailyRecordRepository,
                                                PaymentDailyRecord paymentDailyRecord) {
        paymentDailyRecordRepository.delete(paymentDailyRecord);
    }
}

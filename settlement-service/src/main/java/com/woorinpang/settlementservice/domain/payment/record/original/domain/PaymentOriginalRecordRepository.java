package com.woorinpang.settlementservice.domain.payment.record.original.domain;

import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentOriginalRecordRepository extends JpaRepository<PaymentOriginalRecord, Long> {
    boolean existsByTransactionId(String transactionId);

    List<PaymentOriginalRecord> findAllByPaymentDateYmd(YearMonthDay paymentDateYmd);
}

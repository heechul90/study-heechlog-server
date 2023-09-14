package com.woorinpang.settlementservice.domain.payment.record.original.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOriginalRecordRepository extends JpaRepository<PaymentOriginalRecord, Long> {
    boolean existsByTransactionId(String transactionId);
}

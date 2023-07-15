package com.woorinpang.settlementservice.domain.payment.record.daily.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDailyRecordRepository extends JpaRepository<PaymentDailyRecord, Long> {
}

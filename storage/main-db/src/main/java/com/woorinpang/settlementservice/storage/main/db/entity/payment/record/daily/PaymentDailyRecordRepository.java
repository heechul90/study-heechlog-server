package com.woorinpang.settlementservice.storage.main.db.entity.payment.record.daily;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDailyRecordRepository extends JpaRepository<PaymentDailyRecord, Long> {
}

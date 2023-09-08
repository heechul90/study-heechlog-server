package com.woorinpang.settlementservice.storage.main.db.payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRecordJpaRepository extends JpaRepository<PaymentRecordEntity, Long> {
}

package com.woorinpang.settlementservice.storage.main.db.entity.payment.record.original;

import com.woorinpang.settlementservice.domain.payment.domain.AddPaymentRecordCommand;
import com.woorinpang.settlementservice.domain.payment.domain.PaymentRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentOriginalRecordEntityRepository implements PaymentRecordRepository {
    private final PaymentOriginalRecordJpaRepository repository;

    @Override
    public Long add(AddPaymentRecordCommand command) {
        return repository.save(new PaymentOriginalRecordEntity(command)).getId();
    }
}

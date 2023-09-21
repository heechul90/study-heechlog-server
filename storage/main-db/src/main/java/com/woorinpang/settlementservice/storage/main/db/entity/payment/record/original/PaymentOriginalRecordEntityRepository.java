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
        PaymentOriginalRecordEntity paymentRecord = PaymentOriginalRecordEntity.create()
                .transactionId(command.transactionId())
                .company(new Company(command.company().companyId(), command.company().companyName()))
                .store(new Store(command.store().storeId(), command.store().storeName()))
                .user(new User(command.user().userId(), command.user().userName()))
                .paymentAmount(PaymentAmount.of(
                        command.paymentAmount().paymentAmount(),
                        command.paymentAmount().companySettlementAmount(),
                        command.paymentAmount().storeSettlementAmount())
                )
                .payment(new Payment(command.paymentDay().paymentDate(), command.paymentDay().paymentDateYmd()))
                .paymentType(PaymentType.GENERAL)
                .build();
        return repository.save(paymentRecord).getId();
    }
}

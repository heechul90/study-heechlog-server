package com.woorinpang.settlementservice.domain.payment.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentRecordService {
    private final AddPaymentRecord addPaymentRecord;

    public Long add(String transactionId, Company company, Store store, User user, PaymentAmount paymentAmount, PaymentDay paymentDay) {
        AddPaymentRecordCommand command = AddPaymentRecordCommand.builder()
                .transactionId(transactionId)
                .company(company)
                .store(store)
                .user(user)
                .paymentAmount(paymentAmount)
                .paymentDay(paymentDay)
                .build();
        return addPaymentRecord.add(command);
    }
}

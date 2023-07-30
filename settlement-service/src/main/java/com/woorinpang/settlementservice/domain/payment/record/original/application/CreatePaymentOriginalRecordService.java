package com.woorinpang.settlementservice.domain.payment.record.original.application;

import com.woorinpang.settlementservice.domain.payment.record.original.application.dto.command.CreatePaymentOriginalRecordCommand;
import com.woorinpang.settlementservice.domain.payment.record.original.application.exception.TransactionIdAlreadyExistsException;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.woorinpang.settlementservice.domain.payment.record.original.application.helper.PaymentOriginalRecordServiceHelper.savePaymentOriginalRecord;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CreatePaymentOriginalRecordService {
    private final PaymentOriginalRecordRepository paymentOriginalRecordRepository;

    /**
     * 결제 원본 기록 생성
     */
    public Long create(CreatePaymentOriginalRecordCommand command) {
        if (paymentOriginalRecordRepository.existsByTransactionId(command.transactionId())) {
            throw new TransactionIdAlreadyExistsException(command.transactionId());
        }

        return savePaymentOriginalRecord(paymentOriginalRecordRepository, command.toPaymentOriginalRecord())
                .getId();
    }
}

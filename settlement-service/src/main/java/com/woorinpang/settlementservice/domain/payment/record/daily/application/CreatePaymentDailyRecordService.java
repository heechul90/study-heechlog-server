package com.woorinpang.settlementservice.domain.payment.record.daily.application;

import com.woorinpang.settlementservice.domain.payment.record.daily.application.dto.command.CreatePaymentDailyRecordCommand;
import com.woorinpang.settlementservice.domain.payment.record.daily.domain.PaymentDailyRecordRepository;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CreatePaymentDailyRecordService {
    private final PaymentDailyRecordRepository paymentDailyRecordRepository;
    private final PaymentOriginalRecordRepository paymentOriginalRecordRepository;

    public Long create(CreatePaymentDailyRecordCommand command) {
        List<PaymentOriginalRecord> paymentOriginalRecords = paymentOriginalRecordRepository.findAllByPaymentDateYmd(command.paymentDateYmd());

        return null;
    }
}

package com.woorinpang.settlementservice.domain.payment.record.daily.application;

import com.woorinpang.settlementservice.domain.payment.record.common.entity.PaymentAmount;
import com.woorinpang.settlementservice.domain.payment.record.daily.application.dto.command.CreatePaymentDailyRecordCommand;
import com.woorinpang.settlementservice.domain.payment.record.daily.domain.PaymentDailyRecordRepository;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.domain.payment.record.original.infrastructure.PaymentOriginalRecordQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.woorinpang.settlementservice.domain.payment.record.daily.application.helper.PaymentDailyRecordServiceHelper.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CreatePaymentDailyRecordService {
    private final PaymentDailyRecordRepository paymentDailyRecordRepository;
    private final PaymentOriginalRecordQueryRepository paymentOriginalRecordQueryRepository;

    public Long create() {
        return null;
    }

    public Long reCreate(CreatePaymentDailyRecordCommand command) {
        List<PaymentOriginalRecord> paymentOriginalRecords = paymentOriginalRecordQueryRepository
                .findAllByCompanyAndStore(command.companyId().getCompanyId(), command.storeId().getStoreId(), command.paymentDateYmd());
        return savePaymentDailyRecord(paymentDailyRecordRepository, command.toPaymentDailyRecord(PaymentAmount.of(paymentOriginalRecords)))
                .getId();
    }
}

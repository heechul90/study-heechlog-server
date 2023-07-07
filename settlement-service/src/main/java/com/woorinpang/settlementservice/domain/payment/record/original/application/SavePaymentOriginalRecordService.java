package com.woorinpang.settlementservice.domain.payment.record.original.application;

import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class SavePaymentOriginalRecordService {
    private final PaymentOriginalRecordRepository paymentOriginalRecordRepository;
}

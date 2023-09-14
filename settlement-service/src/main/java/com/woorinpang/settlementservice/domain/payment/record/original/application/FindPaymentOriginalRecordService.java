package com.woorinpang.settlementservice.domain.payment.record.original.application;

import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecordRepository;
import com.woorinpang.settlementservice.domain.payment.record.original.infrastructure.PaymentOriginalRecordQueryRepository;
import com.woorinpang.settlementservice.domain.payment.record.original.infrastructure.dto.find.FindPagePaymentOriginalRecordResponse;
import com.woorinpang.settlementservice.domain.payment.record.original.infrastructure.dto.search.PaymentOriginalRecordSearchCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.woorinpang.settlementservice.domain.payment.record.original.application.helper.PaymentOriginalRecordServiceHelper.findPaymentOriginalRecordById;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FindPaymentOriginalRecordService {
    private final PaymentOriginalRecordRepository paymentOriginalRecordRepository;
    private final PaymentOriginalRecordQueryRepository paymentOriginalRecordQueryRepository;

    /**
     * 결제 원본 기록 목록조회
     */
    public Page<FindPagePaymentOriginalRecordResponse> findPagePaymentOriginalRecord(PaymentOriginalRecordSearchCondition condition, Pageable pageable) {
        return paymentOriginalRecordQueryRepository.findPagePaymentOriginalRecord(condition, pageable);
    }

    /**
     * 결제 원본 기록 단건조회
     */
    public PaymentOriginalRecord findPaymentOriginalRecord(Long paymentOriginalRecordId) {
        return findPaymentOriginalRecordById(paymentOriginalRecordRepository, paymentOriginalRecordId);
    }
}

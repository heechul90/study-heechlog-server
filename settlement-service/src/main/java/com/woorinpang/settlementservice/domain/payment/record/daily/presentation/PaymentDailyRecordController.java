package com.woorinpang.settlementservice.domain.payment.record.daily.presentation;

import com.woorinpang.settlementservice.domain.payment.record.daily.application.CreatePaymentDailyRecordService;
import com.woorinpang.settlementservice.domain.payment.record.daily.presentation.dto.request.CreatePaymentDailyRecordRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment/daily/records")
public class PaymentDailyRecordController {
    private final CreatePaymentDailyRecordService createPaymentDailyRecordService;

    /**
     * 컴퍼니 스토어 결제일일기록 재생성
     */
    @PostMapping
    public ResponseEntity reCreateCompanyStorePaymentDailyRecord(CreatePaymentDailyRecordRequest request) {
        createPaymentDailyRecordService.reCreate(request.toCommend());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("");
    }
}

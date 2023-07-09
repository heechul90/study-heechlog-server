package com.woorinpang.settlementservice.domain.payment.record.daily.presentation;

import com.woorinpang.settlementservice.domain.payment.record.daily.application.CreatePaymentDailyRecordService;
import com.woorinpang.settlementservice.domain.payment.record.daily.presentation.dto.request.createPaymentDailyRecordRequest;
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
     * 결제일일기록 생성
     */
    @PostMapping
    public ResponseEntity createPaymentDailyRecord(createPaymentDailyRecordRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("");
    }
}
